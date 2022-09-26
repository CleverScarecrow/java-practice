package com.scarecrow.concurrent.day07;

import java.util.Arrays;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {

    private static volatile PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(Arrays.asList(18, 15, 22));

    public static void main(String[] args) throws InterruptedException {
        queue.put(10);
        System.out.println(queue.take());
        System.out.println(8>>1);
        queue.peek();
    }
}
