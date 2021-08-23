package com.gyy.demo.juc;

public class A1B2C3D4 {


    public static void main(String[] args) {

        final Object lock = new Object();
        Thread t1 = new Thread(() -> {
            String[] strings = {"A", "B", "C", "D"};
            synchronized (lock) {
                for (int i = 0; i < strings.length; i++) {

                    lock.notify();
                    try {
                        System.out.println(strings[i]);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread t2 = new Thread(() -> {
            String[] strings1 = {"1", "2", "3", "4"};
            synchronized (lock) {
                for (int i = 0; i < strings1.length; i++) {

                    lock.notify();
                    try {
                        System.out.println(strings1[i]);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });


        t1.start();
        t2.start();
    }
}
