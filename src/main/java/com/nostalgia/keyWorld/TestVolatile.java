package com.nostalgia.keyWorld;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liunian
 * @createTime 2019/10/14
 * @description
 */
public class TestVolatile {

    private static volatile AtomicInteger variable = new AtomicInteger(0);

    public static void increase(){
        variable.getAndIncrement();
    }

    /*public static void main(String[] args) {

        for (int i = 0;i<20;i++ ){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j =0;j<10000;j++)
                    increace();
                }
            }).start();

        }
        while (Thread.activeCount()>1)
            Thread.yield();
        System.out.println(variable);

    }*/
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            thread.start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(variable);
    }

}
