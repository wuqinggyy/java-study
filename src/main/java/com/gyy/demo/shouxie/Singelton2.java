package com.gyy.demo.shouxie;

/**
 * 饿汉
 */
public class Singelton2 {

    private static volatile Singelton2 instance = null;

    private Singelton2() {

    }

    public static Singelton2 getInstance() {
        if (instance == null) {
            synchronized (Singelton2.class) {
                if (instance == null) {
                    instance = new Singelton2();
                }
            }
        }
        return instance;
    }

}
