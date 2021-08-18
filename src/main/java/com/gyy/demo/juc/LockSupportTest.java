package com.gyy.demo.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    static Thread t1;
    static Thread t2;

    public static void main(String[] args) {
        LockSupportTest lockSupportTest = new LockSupportTest();

        t1 = new Thread(() -> {
            System.out.println("t1 qidong");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                lockSupportTest.add(new Object());
                if (lockSupportTest.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        }, "t1");

        t2 = new Thread(() -> {
            System.out.println("t2 qidong");
            LockSupport.park();
            System.out.println("t2 结束");
            LockSupport.unpark(t1);
        }, "t2");

        t2.start();
        t1.start();
    }
}
