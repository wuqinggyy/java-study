package com.gyy.demo.service.netty;

import java.nio.IntBuffer;

public class BasicBuffer {

    public static void main(String[] args) {
        //创建buff
        IntBuffer intBuffer = IntBuffer.allocate(5);

        for (int i = 0; i < intBuffer.capacity() ; i++) {

            System.out.println(i * 2);
        }

        //进行读写转换
        intBuffer.flip();

        while(intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }

    }
}
