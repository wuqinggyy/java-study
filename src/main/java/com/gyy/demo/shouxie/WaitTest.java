package com.gyy.demo.shouxie;

import java.util.ArrayList;
import java.util.List;

public class WaitTest {

    List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        WaitTest waitTest = new WaitTest();

        final Object lock = new Object();
        Thread t1 = new Thread(() -> {
            System.out.println("t1 qidong");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    waitTest.add(new Object());
                    if (waitTest.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }, "t1");

        Thread t2 = new Thread(() -> {
            System.out.println("t2 qidong");
            synchronized (lock) {
                if (waitTest.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
                lock.notify();
            }
        }, "t2");

        t2.start();
        t1.start();
    }
}
