package com.scarecrow.concurrent.day07;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class LinkedTransferQueueDemo {
    private static final LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                // 阻塞
                if (finalI == 1) {
                    try {
                        queue.transfer(finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    queue.put(finalI);
                }
                System.out.println("--- " + finalI + " ---");
            },"IIIIII:" + finalI);
            TimeUnit.MILLISECONDS.sleep(10);
            thread.start();
        }
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("count:" + Thread.activeCount());
        /*for (int i = 0; i < 3; i ++) {
            queue.take();
        }*/
    }
}
