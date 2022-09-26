package com.scarecrow.concurrent.day01;

import java.util.concurrent.TimeUnit;

public class RunnableDemo {

    static class ChildThread implements Runnable{
        @Override
        public void run() {
            System.out.println("childThread");
        }
    }

    public static void main(String[] args) throws Exception {
        ChildThread childThread = new ChildThread();
        Thread thread = new Thread(childThread);
        System.out.println("mainThread");
        TimeUnit.SECONDS.sleep(5);
        thread.start();
    }
}
