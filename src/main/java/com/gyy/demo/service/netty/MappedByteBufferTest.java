package com.gyy.demo.service.netty;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer 可以直接在内存(堆外内存)中修改文件，不需要操作系统拷贝
 */
public class MappedByteBufferTest {

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/gongyy/Desktop/图片/1.txt";
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");

        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 6);
        map.put(0, (byte) 'H');
        map.put(7, (byte) 8);
        randomAccessFile.close();

    }

}
