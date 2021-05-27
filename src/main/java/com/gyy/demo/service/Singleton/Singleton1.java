package com.gyy.demo.service.Singleton;

/**
 * 懒汉式（双重同步锁）
 */
public class Singleton1 {

    //使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行
    private static volatile Singleton1 instance = null;

    //私有构造方法
    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (instance == null) {
            //类对象加锁
            synchronized (Singleton1.class) {
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}
