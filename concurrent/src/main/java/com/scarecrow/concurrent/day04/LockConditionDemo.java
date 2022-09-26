package com.scarecrow.concurrent.day04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionDemo {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            System.out.println("threadA start");
            lock.lock();
            System.out.println("threadA getLock Running");
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println("threadA end");
        });

        Thread threadB = new Thread(() -> {
            System.out.println("threadB start");
            lock.lock();
            System.out.println("threadB getLock Running");
            condition.signal();
            lock.unlock();
            System.out.println("threadB end");
        });

        threadA.start();
        TimeUnit.SECONDS.sleep(2);
        threadB.start();
    }
}
