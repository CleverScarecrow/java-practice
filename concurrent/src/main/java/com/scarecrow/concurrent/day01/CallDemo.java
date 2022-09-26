package com.scarecrow.concurrent.day01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallDemo {

    public static class Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("call_start");
            // 模拟计算需要10秒
            TimeUnit.SECONDS.sleep(10);
            System.out.println("call_end");
            return "call_result";
        }
    }

    /**
     * 异步执行，等待获取结果get()
     * */
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("result_start");
        Future<String> result = executorService.submit(task);
        System.out.println("result_end");
        // 阻塞10S获取结果
        System.out.println("result---" + result.get());
        executorService.shutdown();
    }
}
