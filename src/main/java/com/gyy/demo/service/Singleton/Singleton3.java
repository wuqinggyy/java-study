package com.gyy.demo.service.Singleton;

/**
 * 静态内部类
 */
public class Singleton3 {

    private Singleton3() {
    }

    private static class SingletonHolder {
        public static Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.instance;
    }
}
