package com.gyy.demo.service.Singleton;

/**
 * 饿汉式：线程安全，调用效率高。但是不能延时加载
 */
public class Singelton2 {

    private static Singelton2 instance = new Singelton2();

    private Singelton2(){

    }

    public static Singelton2 getInstance(){
        return  instance;
    }
}
