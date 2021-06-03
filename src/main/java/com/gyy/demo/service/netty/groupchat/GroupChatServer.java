package com.gyy.demo.service.netty.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class GroupChatServer {

    //定义属性
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int port = 6667;

    public GroupChatServer() {
        try {

            //得到选择器
            selector = Selector.open();
            //得到监控channel
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress("127.0.0.1", port));
            //设置非阻塞
            listenChannel.configureBlocking(false);
            //将channel注册到selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (Exception e) {
        }
    }

    public void listen() {
        try {
            while (true) {
                int count = selector.select(2000);
                if (count > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        if (selectionKey.isAcceptable()) {
                            SocketChannel channel = listenChannel.accept();
                            channel.configureBlocking(false);
                            channel.register(selector, SelectionKey.OP_READ);
                            System.out.println(channel.getRemoteAddress() + "上线了");
                        }
                        if (selectionKey.isReadable()) {
                            readData(selectionKey);
                        }
                        //删除当前key，防止重复处理
                        iterator.remove();
                    }
                } else {
                    System.out.println("等待");
                }
            }
        } catch (
            Exception e) {
        }
    }


    public void readData(SelectionKey key) {
        //得到key对应的channle
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) key.channel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = channel.read(buffer);
            if (read > 0) {
                String msg = new String(buffer.array());
                System.out.println("form 客户端: " + msg);
                sendInfoToOtherClients(msg, channel);
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + " 离线了..");
                //取消注册
                key.cancel();
                //关闭通道
                channel.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }


    }

    public void sendInfoToOtherClients(String msg, SocketChannel self) throws IOException {
        System.out.println("转发消息中");
        for (SelectionKey key : selector.keys()) {
            //通过key获取对应的channel
            Channel channel = key.channel();
            //排除自己
            if (channel instanceof SocketChannel && channel != self) {
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                ((SocketChannel) channel).write(buffer);
            }
        }

    }

    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }

}
