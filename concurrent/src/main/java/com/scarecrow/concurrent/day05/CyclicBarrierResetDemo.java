package com.scarecrow.concurrent.day05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierResetDemo {

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new CyclicBarrierThreadA());
        Thread threadB = new Thread(new CyclicBarrierThreadB());
        Thread threadC = new Thread(new CyclicBarrierThreadC());
        Thread threadD = new Thread(new CyclicBarrierThreadD());
        threadA.start();
        TimeUnit.MILLISECONDS.sleep(100);
        threadB.start();
        TimeUnit.MILLISECONDS.sleep(100);
        // cyclicBarrier.reset()
        // 破坏栅栏的当前代
        // 重新设置下一代
        // 唤醒此栅栏其他等待的线程。即A和B.即使parties没有到达3次
        threadD.start();
        TimeUnit.MILLISECONDS.sleep(100);
        // 此时threadC即使执行await,一共执行了3次。由于栅栏重新设置了下一代，同样需要等待
        threadC.start();

    }

    static class CyclicBarrierThreadA implements Runnable {
        @Override
        public void run() {
            System.out.println("---CyclicBarrierThreadA---   start");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("---CyclicBarrierThreadA---   end");
        }
    }

    static class CyclicBarrierThreadB implements Runnable {
        @Override
        public void run() {
            System.out.println("---CyclicBarrierThreadB---   start");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("---CyclicBarrierThreadB---   end");
        }
    }


    static class CyclicBarrierThreadC implements Runnable {
        @Override
        public void run() {
            System.out.println("---CyclicBarrierThreadC---   start");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("---CyclicBarrierThreadC---   end");
        }
    }


    static class CyclicBarrierThreadD implements Runnable {
        @Override
        public void run() {
            System.out.println("---CyclicBarrierThreadD---   start");
            cyclicBarrier.reset();
            System.out.println("---CyclicBarrierThreadD---   end");
        }
    }

}
