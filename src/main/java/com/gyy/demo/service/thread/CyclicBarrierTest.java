package com.gyy.demo.service.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {


    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("等待其他线程执行结束");
            }
        });

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
            15, 1,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(100)
        );

        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
//                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "线程执行");
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
