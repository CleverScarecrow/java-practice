package com.scarecrow.concurrent.day10;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangbo
 * @description
 * @date 2020/12/28
 */
public class ThreadPoolTestDemo {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
            2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0 ; i < 8; i++) {
            executor.execute(new ThreadPoolParametersDemo.ExecutorTask(i));
        }
        System.out.println("PoolSize---" + executor.getPoolSize());
        TimeUnit.SECONDS.sleep(14);
        System.out.println("PoolSize---" + executor.getPoolSize());
        executor.shutdown();
    }

    static class ExecutorTask implements Runnable {
        private int threadNum;

        public ExecutorTask(int threadNum) {
            this.threadNum = threadNum;
        }

        @Override
        public void run() {
            // System.out.println(Thread.currentThread().getName() + "---threadStart---" + threadNum);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // System.out.println(Thread.currentThread().getName() + "---threadEnd---" + threadNum);
        }
    }
}
