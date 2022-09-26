package com.scarecrow.concurrent.day07;

import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeDemo {

    private static LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>(10);

    public static void main(String[] args) throws InterruptedException {
        linkedBlockingDeque.putFirst(1);
        linkedBlockingDeque.putLast(2);
        linkedBlockingDeque.takeFirst();
        linkedBlockingDeque.takeLast();
    }
}
