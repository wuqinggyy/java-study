package com.gyy.demo.service.ThreadPool;


import java.util.Date;

public class MyRunnable implements Runnable{


    private String a;

    public MyRunnable(String s){
        this.a = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +  " Start. Time = " + new Date());
        sleep();
        System.out.println(Thread.currentThread().getName() +  " end. Time = " + new Date());
    }

    private void sleep(){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    @Override
    public String toString() {
        return this.a;
    }
}
