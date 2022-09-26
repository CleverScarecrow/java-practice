package com.scarecrow.concurrent.day10;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    private static SynchronousQueue<String> queue = new SynchronousQueue();

    private static Thread[] product = new Thread[10];

    private static Thread[] consumer = new Thread[10];

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    queue.put(String.valueOf(finalI));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "---put :" + finalI);
            }, "product线程：" + i);
            product[i] = thread;
        }

        for (int j = 0; j < 10; j++) {
            Thread thread = new Thread(() -> {
                try {
                    String take = queue.take();
                    System.out.println(Thread.currentThread().getName() + "---take：" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "consumer线程：" + j);
            consumer[j] = thread;
        }

        for (Thread item : product) {
            item.start();
        }

        TimeUnit.SECONDS.sleep(3);

        for (Thread item : consumer) {
            item.start();
        }
    }
}
