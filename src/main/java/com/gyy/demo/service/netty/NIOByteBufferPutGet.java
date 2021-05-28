package com.gyy.demo.service.netty;

import java.nio.ByteBuffer;

public class NIOByteBufferPutGet {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.putInt(2);
        byteBuffer.putChar('萨');
        byteBuffer.putLong(3);

        byteBuffer.flip();


        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getLong());


    }
}
