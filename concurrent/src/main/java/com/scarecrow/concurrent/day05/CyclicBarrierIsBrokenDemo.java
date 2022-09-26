package com.scarecrow.concurrent.day05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierIsBrokenDemo {
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new CyclicBarrierThreadA());
        Thread threadB = new Thread(new CyclicBarrierThreadB());
        Thread threadC = new Thread(new CyclicBarrierThreadC());
        threadA.start();
        TimeUnit.MILLISECONDS.sleep(100);
        threadB.start();
        TimeUnit.MILLISECONDS.sleep(100);
        // condition await时被中断会breakBarrier，并抛出异常
        threadA.interrupt();
        TimeUnit.MILLISECONDS.sleep(100);
        // breakBarrier后线程C抛出BrokenBarrierException
        // cyclicBarrier.isBroken为true
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
                System.out.println("cyclicBarrierBrokenFlag: " + cyclicBarrier.isBroken());
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("---CyclicBarrierThreadC---   end");
        }
    }

}
