package com.scarecrow.concurrent.day10;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 验证核心参数
 */
public class ThreadPoolParametersDemo {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
            2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 11; i++) {
            executor.execute(new ExecutorTask(i));
            // 返回池中的当前线程数。
            System.out.println("PoolSize---" + executor.getPoolSize());
            TimeUnit.MILLISECONDS.sleep(1);
        }
        // 返回计划执行的任务总数（未完成+已完成）。由于任务和线程的状态在计算过程中可能会动态更改，因此返回的值只是一个近似值
        System.out.println("TaskCount---" + executor.getTaskCount());
        // 返回已完成执行的任务的总数（近似值）。
        System.out.println("CompletedTaskCount---" + executor.getCompletedTaskCount());
        // 返回池中曾经同时存在的最大线程数。
        System.out.println("LargestPoolSize---" + executor.getLargestPoolSize());
        TimeUnit.SECONDS.sleep(5);
        executor.execute(new ExecutorTask(11));
        executor.execute(new ExecutorTask(12));
        System.out.println("PoolSize---" + executor.getPoolSize());
        System.out.println("ActiveCount---" + executor.getActiveCount());
        // 5s后创建了两个新的线程达到最大线程数
        System.out.println("LargestPoolSize---" + executor.getLargestPoolSize());
        TimeUnit.SECONDS.sleep(10);
        System.out.println("TaskCount---" + executor.getTaskCount());
        System.out.println("CompletedTaskCount---" + executor.getCompletedTaskCount());
        System.out.println("PoolSize---" + executor.getPoolSize());
        System.out.println("ActiveCount---" + executor.getActiveCount());
        TimeUnit.SECONDS.sleep(30);
        // 返回池中的当前线程数。非核心线程都销毁，只剩下核心线程数：5
        System.out.println("PoolSize---" + executor.getPoolSize());
        System.out.println("ActiveCount---" + executor.getActiveCount());
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
                TimeUnit.SECONDS.sleep(10 + threadNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // System.out.println(Thread.currentThread().getName() + "---threadEnd---" + threadNum);
        }
    }

}
