package com.gyy.demo.service.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {


    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(4);

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("打印" + Thread.currentThread().getName());
                countDownLatch.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程" + 1);

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("打印" + Thread.currentThread().getName());
                countDownLatch.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程" + 2);

        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("打印" + Thread.currentThread().getName());
                countDownLatch.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程" + 3);

        Thread t4 = new Thread(() -> {
            try {
                Thread.sleep(4000);
                System.out.println("打印" + Thread.currentThread().getName());
                countDownLatch.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程" + 4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            countDownLatch.await();
            System.out.println("打印开始");
            Thread.sleep(10000);
            System.out.println("打印结束");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
