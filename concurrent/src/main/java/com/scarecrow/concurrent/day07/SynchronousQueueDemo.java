package com.scarecrow.concurrent.day07;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    private static SynchronousQueue<Integer> queue = new SynchronousQueue(true);

    public static void main(String[] args) throws InterruptedException {
        Thread productThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                new Thread(() -> {
                    try {
                        queue.put(finalI);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumeThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("take：" + queue.take());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        productThread.start();
        TimeUnit.SECONDS.sleep(30);
        consumeThread.start();

    }
}
