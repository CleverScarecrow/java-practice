package com.scarecrow.concurrent.day10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewCachedThreadPoolDemo {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            executorService.execute(new ExecutorTask());
            TimeUnit.MILLISECONDS.sleep(1);
        }
        executorService.shutdown();
    }

    static class ExecutorTask implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "---start");
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {

            }
        }
    }
}
