package com.scarecrow.concurrent.day04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ParkDemo {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("thread strat");
            // LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));，阻塞线程，5s后没有LockSupport.unpark自动返回
            // 阻塞线程
            LockSupport.park();
            System.out.println("thread end");
        });

        thread.start();

        TimeUnit.SECONDS.sleep(3);
        // 唤醒线程thread
        LockSupport.unpark(thread);
        // 也会唤醒处于park状态的线程
//        thread.interrupt();
    }
}
