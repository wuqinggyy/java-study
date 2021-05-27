package com.gyy.demo.service.netty;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bio {

    public static void main(String[] args) throws IOException {

        //1.先创建一个线程池
        //2.如果有客户端链接就创建一个线程，跟客户端通信
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务端启动了");
        while (true) {
            //监听，等待客户端链接
            Socket socket = serverSocket.accept();
            System.out.println("链接到一个客户端");
            //创建一个线程，与客户端通信
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    BioServer.handler(socket);
                }
            });
        }
    }

}
