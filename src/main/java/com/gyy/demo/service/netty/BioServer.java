package com.gyy.demo.service.netty;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.util.Base64Utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author gongyy
 */
public class BioServer {

    public static void handler(Socket socket) {

        System.out.println("id = " +  Thread.currentThread().getId() + Thread.currentThread().getName());
        byte[] bytes = new byte[1024];
        try {
            //通过socket获取输入流
            InputStream inputStream = socket.getInputStream();
            //循环的读取客户端发送的数据
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    //输出客户端发送的数据
                    System.out.println("id = " +  Thread.currentThread().getId() + Thread.currentThread().getName());
                    System.out.println(bytes.toString());

                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭和client的链接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
