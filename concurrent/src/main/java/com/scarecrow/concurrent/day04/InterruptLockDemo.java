package com.scarecrow.concurrent.day04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptLockDemo {

    private static volatile boolean flag = true;

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            System.out.println("threadA start :" + System.currentTimeMillis());
            lock.lock();
            while (true) {
                if (!flag) {
                    break;
                }
            }
            lock.unlock();
            System.out.println("threadA end" + System.currentTimeMillis());
        }, "threadA");

        Thread threadB = new Thread(() -> {
            System.out.println("threadB start" + System.currentTimeMillis());
            // threadB等待锁的释放，不会抛出异常。不会响应中断
            lock.lock();
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("threadB isInterrupted");
            }
            lock.unlock();
            System.out.println("threadB end" + System.currentTimeMillis());
        }, "threadB");

        threadA.start();
        TimeUnit.SECONDS.sleep(1);
        threadB.start();
        TimeUnit.SECONDS.sleep(1);
        // 中断线程threadB
        threadB.interrupt();
        TimeUnit.SECONDS.sleep(5);
        flag = false;
        lock.lockInterruptibly();
    }
}
