package com.scarecrow.concurrent.day07;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {

    private static LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(6);

    public static void main(String[] args) throws InterruptedException {
        linkedBlockingQueue.add(1);
        linkedBlockingQueue.offer(1);
        linkedBlockingQueue.put(1);
        linkedBlockingQueue.remove();
        linkedBlockingQueue.poll();
        linkedBlockingQueue.peek();
        linkedBlockingQueue.element();
        linkedBlockingQueue.take();
    }
}
