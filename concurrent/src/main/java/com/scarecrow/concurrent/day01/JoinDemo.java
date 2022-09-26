package com.scarecrow.concurrent.day01;

import java.util.concurrent.TimeUnit;

public class JoinDemo {

    static class ChildThread implements Runnable {
        @Override
        public void run() {
            System.out.println("Child Thread Start");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Child Thread End");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Start");
        Thread childThread = new Thread(new ChildThread(), "childThread");
        TimeUnit.SECONDS.sleep(1);
        childThread.start();
        childThread.join();
        System.out.println("Main Thread End");
    }
}
