package com.scarecrow.concurrent.day04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            System.out.println("threadA start :" + System.currentTimeMillis());
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("threadA end" + System.currentTimeMillis());
        });

        Thread threadB = new Thread(() -> {
            System.out.println("threadB start" + System.currentTimeMillis());
            lock.lock();
            boolean interruptFlag = Thread.currentThread().isInterrupted();
            System.out.println("interruptFlag----" + interruptFlag);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("threadB end"+ System.currentTimeMillis());
        });
        threadA.start();
        TimeUnit.SECONDS.sleep(1);
        threadB.start();
        TimeUnit.SECONDS.sleep(1);
        // threadB在等待过程中被中断过，它是不响应的。只是获取资源后才再进行自我中断selfInterrupt()，将中断补上
        threadB.interrupt();
    }
}
