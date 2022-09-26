package com.scarecrow.concurrent.day10;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class ParkDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("thread start");
            LockSupport.park();
            if (Thread.interrupted()) {
                System.out.println("thread interrupt");
            }
            System.out.println("thread end");
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

    }
}
