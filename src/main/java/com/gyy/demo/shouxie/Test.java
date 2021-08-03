package com.gyy.demo.shouxie;

public class Test {

    private static Test instance = new Test();

    private Test() {

    }

    public static Test getInstance() {
        return instance;
    }


}
