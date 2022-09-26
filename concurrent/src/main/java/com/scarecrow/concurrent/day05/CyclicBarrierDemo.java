package com.scarecrow.concurrent.day05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new BarrierAction());

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 4; i++) {
            new Thread(new BarrierThread(), String.valueOf(i)).start();
            TimeUnit.MILLISECONDS.sleep(1);
        }
    }

    static class BarrierThread implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("线程： " + Thread.currentThread().getName() + " 启动");
                TimeUnit.SECONDS.sleep(5);
                cyclicBarrier.await();
                System.out.println("线程： " + Thread.currentThread().getName() + " 结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * CyclicBarrier可以再次使用
     */
    static class CyclicBarrierThread implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("线程： " + Thread.currentThread().getName() + " 启动");
                cyclicBarrier.await();
                System.out.println("线程： " + Thread.currentThread().getName() + " 结束");

                TimeUnit.SECONDS.sleep(10);
                System.out.println("线程： " + Thread.currentThread().getName() + " 再次启动");
                cyclicBarrier.await();
                System.out.println("线程： " + Thread.currentThread().getName() + " 再次结束");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    static class BarrierAction implements Runnable {
        @Override
        public void run() {
            System.out.println("屏障都到达后，第一个先执行的线程");
        }
    }
}
