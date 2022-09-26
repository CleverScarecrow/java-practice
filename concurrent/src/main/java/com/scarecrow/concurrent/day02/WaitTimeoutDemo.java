package com.scarecrow.concurrent.day02;

import java.util.concurrent.TimeUnit;

public class WaitTimeoutDemo {

    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread threadWait = new Thread(() -> {
            synchronized (lock) {
                System.out.println("threadWait:stat");
                try {
                    lock.wait(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadWait:end");
            }
        });
        threadWait.start();

        Thread threadNotify = new Thread(() -> {
            synchronized (lock) {
                System.out.println("threadNotify:start");
                try {
                    TimeUnit.SECONDS.sleep(10);
                    lock.notify();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadNotify:end");
            }
        });
        threadNotify.start();
    }

}
