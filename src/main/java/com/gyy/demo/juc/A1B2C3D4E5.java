package com.gyy.demo.juc;

import java.util.concurrent.locks.LockSupport;

public class A1B2C3D4E5 {

    static Thread t1;
    static Thread t2;

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            String[] strings = {"A", "B", "C", "D", "E"};

            for (int i = 0; i < strings.length; i++) {
                System.out.println(strings[i]);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            String[] strings1 = {"1", "2", "3", "4", "5"};
            for (int i = 0; i < strings1.length; i++) {
                System.out.println(strings1[i]);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        });

        t1.start();
        t2.start();
    }
}
