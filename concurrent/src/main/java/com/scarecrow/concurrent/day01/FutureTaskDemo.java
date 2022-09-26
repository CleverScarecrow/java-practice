package com.scarecrow.concurrent.day01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskDemo {

    public static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("call_start");
            // 模拟计算需要10秒
            TimeUnit.SECONDS.sleep(10);
            System.out.println("call_end");
            return 8;
        }
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
        System.out.println("result-start");
        executor.submit(futureTask);
        System.out.println("result-end");
        // 阻塞10S获取结果
        System.out.println("result-"+futureTask.get());
        executor.shutdown();
    }
}
