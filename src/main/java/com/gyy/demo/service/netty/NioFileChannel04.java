package com.gyy.demo.service.netty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class NioFileChannel04 {

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/gongyy/Desktop/图片/22222.jpg";
        String filePath1 = "/Users/gongyy/Desktop/图片/2222233.jpg";

        FileInputStream fileInputStream = new FileInputStream(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath1);

        FileChannel input = fileInputStream.getChannel();
        FileChannel outPut = fileOutputStream.getChannel();

//        outPut.transferFrom(input, 0, input.size());
        input.transferTo(0,input.size(),outPut);

        fileInputStream.close();
        fileOutputStream.close();
    }
}
