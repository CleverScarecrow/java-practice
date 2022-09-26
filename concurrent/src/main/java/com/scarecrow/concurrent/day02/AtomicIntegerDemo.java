package com.scarecrow.concurrent.day02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangbo
 * @description
 * @date 2020/7/14
 */
public class AtomicIntegerDemo {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            new Thread(() -> {
                int s = atomicInteger.getAndIncrement();
                System.out.println("s_" + s);
            }).start();
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println(atomicInteger.get());
    }
}
