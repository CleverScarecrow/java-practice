package com.scarecrow.concurrent.day02;

import java.util.concurrent.TimeUnit;

public class WaitNotifyDemo {

    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            synchronized (object) {
                System.out.println("ThreadA---Start");
                try {
                    // 释放锁等待
                    object.wait();
                    System.out.println("ThreadA---Wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (object) {
                System.out.println("ThreadB---Start");
                // 唤醒ThreadA,需要注意的是（ThreadB需要执行完同步代码）
                object.notify();
                System.out.println("ThreadB---Wait");
            }
        });

        threadA.start();
        TimeUnit.SECONDS.sleep(2);
        threadB.start();
        threadA.join();
        threadB.join();
    }
}
