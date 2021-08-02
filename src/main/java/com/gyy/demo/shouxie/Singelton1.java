package com.gyy.demo.shouxie;

/**
 * 懒汉
 */
public class Singelton1 {

    private static Singelton1 instance = new Singelton1();

    private Singelton1(){

    }

    public static Singelton1 getInstance(){

        return instance;
    }


}
