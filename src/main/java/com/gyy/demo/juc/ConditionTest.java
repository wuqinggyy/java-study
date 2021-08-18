package com.gyy.demo.juc;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者
 */
public class ConditionTest<T> {

    final private LinkedList<T> list = new LinkedList<T>();
    final int max = 10;
    int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();
    private Condition producer = lock.newCondition();


    public void put(T t) {
        lock.lock();
        try {
            while (list.size() == max) {
                producer.await();
            }
            list.add(t);
            ++count;
            consumer.signalAll();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T t = null;
        lock.lock();
        try {
            while (list.size() == 0) {
                consumer.await();
            }
            t = list.removeFirst();
            count--;
            producer.notifyAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(conditionTest.get());
                }
            }, "c" + i).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {

                for (int j = 0; j < 25; j++) {
                    conditionTest.put(Thread.currentThread().getName() + "" + j);
                }
            }, "p" + i).start();
        }
    }

}
