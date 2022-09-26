package com.scarecrow.concurrent.day04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {
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
            System.out.println("threadB start: " + System.currentTimeMillis());
            try {
                // 超时等待锁
                if (lock.tryLock(20, TimeUnit.SECONDS)) {
                    System.out.println("threadB get Lock");
                    lock.unlock();
                } else {
                    System.out.println("threadB cnt not get Lock");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("threadB end" + System.currentTimeMillis());
        }, "threadB");
        threadA.start();
        TimeUnit.SECONDS.sleep(1);
        threadB.start();
        TimeUnit.SECONDS.sleep(1);
        threadB.interrupt();
        flag = false;
    }
}
