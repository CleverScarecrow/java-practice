package com.scarecrow.concurrent.day02;

import java.util.concurrent.TimeUnit;

/**
 * 线程安全问题
 */
public class SynDemo {

    private static int count = 0;

    private static void incr() {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (SynDemo.class) {
            count++;
        }
    }

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 1000; i++) {
            new Thread(SynDemo::incr).start();
        }
        TimeUnit.SECONDS.sleep(3);

        System.out.println("运行结果"+count);
    }
}
