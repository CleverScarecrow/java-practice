package com.scarecrow.concurrent.day05;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author wangbo
 * @description CountDownLatch
 * countdownlatch 是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完毕再执行。
 * countdownlatch 提供了两个方法，一个是 countDown，一个是 await。
 * countdownlatch 初始化的时候需要传入一整数，在这个整数倒数到 0 之前，调用了await方法的
 * 程序都必须要等待，然后通过 countDown来倒数。
 * @date 2020/9/24
 */
public class CountDownLatchDemo {

    private static final CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) {
        try {
            System.out.println("main线程开始执行");
            for (int i = 0; i < 3; i++) {
                new Thread(new CountDownLatchThread(), String.valueOf(i)).start();
                TimeUnit.SECONDS.sleep(1);
            }
            // 阻塞，直到countDownLatch为0
            // main线程等待3个子线程都执行完成会被唤醒
            countDownLatch.await();
            System.out.println("main线程执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class CountDownLatchThread implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "开始执行");
                TimeUnit.SECONDS.sleep(10);
                // 当前线程调用此方法，则计数减一
                countDownLatch.countDown();
                // 子线程之间互相等待彼此都执行countDownLatch.countDown()后会唤醒
                countDownLatch.await();
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

