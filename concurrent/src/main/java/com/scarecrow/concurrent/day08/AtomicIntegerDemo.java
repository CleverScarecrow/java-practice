package com.scarecrow.concurrent.day08;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    // 多线程情况下，即使加了volatile修饰符。count++不是原子操作也会存在并发问题
    private static volatile int count = 0;
    // AtomicInteger通过cas原子操作，cas不成功后,会继续进行cas的尝试
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i =0 ; i < 100000 ; i++) {
            new IncrThread().start();
        }

        TimeUnit.SECONDS.sleep(20);
        System.out.println("count:" + count);

        for (int i =0 ; i < 100000 ; i++) {
            new AtomicIncrThread().start();
        }

        TimeUnit.SECONDS.sleep(20);
        System.out.println("atomicInteger:" + atomicInteger.get());
    }

    static class IncrThread extends Thread{

        @Override
        public void run() {
            count++;
        }
    }

    static class AtomicIncrThread extends Thread{

        @Override
        public void run() {
            atomicInteger.incrementAndGet();
        }
    }
}
