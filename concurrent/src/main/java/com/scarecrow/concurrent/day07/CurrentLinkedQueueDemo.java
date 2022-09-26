package com.scarecrow.concurrent.day07;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CurrentLinkedQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.size();
        queue.isEmpty();
        queue.poll();
    }
}
