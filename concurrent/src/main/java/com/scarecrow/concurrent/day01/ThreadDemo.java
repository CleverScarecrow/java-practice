package com.scarecrow.concurrent.day01;

import java.util.concurrent.TimeUnit;

public class ThreadDemo {

    static class ChildThread extends Thread {
        @Override
        public void run() {
            System.out.println("childThread");
        }
    }

    public static void main(String[] args) throws Exception {
        ChildThread childThread = new ChildThread();
        System.out.println("mainThread");
        TimeUnit.SECONDS.sleep(5);
        childThread.start();
    }
}
