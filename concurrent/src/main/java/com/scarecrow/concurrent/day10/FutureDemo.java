package com.scarecrow.concurrent.day10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> stringFutureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("---stringFutureTask---");
                TimeUnit.SECONDS.sleep(5);
                return "FutureTaskCall";
            }
        });

        new Thread(stringFutureTask).start();
        TimeUnit.SECONDS.sleep(6);
        System.out.println("====" + stringFutureTask.cancel(true));
        System.out.println("====" + stringFutureTask.isCancelled());
        // 阻塞10s
        System.out.println("stringFutureTask---" + stringFutureTask.get());
        System.out.println("-------------------------------------------");

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(15);
        // executeDemo
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("executeRunnable");
            }
        });
        TimeUnit.SECONDS.sleep(1);
        System.out.println("-------------------------------------------");

        // submitCallableDemo
        Future<String> submitCall = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("submitCallable");
                TimeUnit.SECONDS.sleep(2);
                return "submitCallable";
            }
        });
        // 阻塞5秒获取结果
        System.out.println("submitCall---" + submitCall.get());
        System.out.println("-------------------------------------------");

        // submitRunnableDemo_1
        Future<?> submitRunnable1 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("submitRunnable");
            }
        });
        // null
        System.out.println("submitRunnable1---" + submitRunnable1.get());
        System.out.println("-------------------------------------------");

        // submitRunnableDemo_2
        String submitRunnable2Result = "submitRunnable2Result";
        Future<String> submitRunnable2 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("submitRunnable");
            }
        }, submitRunnable2Result);
        // null
        System.out.println("submitRunnable2---" + submitRunnable2.get());
        System.out.println("-------------------------------------------");
        // FutureTaskDemo
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("futureTask");
                TimeUnit.SECONDS.sleep(2);
                return "futureTask";
            }
        });
        executorService.submit(futureTask);
        // 阻塞两秒
        System.out.println("futureTask---" + futureTask.get());
        System.out.println("-------------------------------------------");
        executorService.shutdown();
    }
}
