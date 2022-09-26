package com.scarecrow.concurrent.day01;

import java.util.concurrent.TimeUnit;

/**
 * @author wangbo
 * @description:thread.interrupt() and Thread.interrupted()
 * @date 2020/6/29
 */
public class InterruptDemo {

    public static void main(String[] args) throws Exception{
        Thread threadA = new Thread(() -> {
            System.out.println("threadA start time :" + System.currentTimeMillis());
             // thread.isInterrupted()默认为false
             // 当thread.interrupt,会变为true
             while (!Thread.currentThread().isInterrupted()) {

             }
             // thread.isInterrupted()不会进行复位
            System.out.println("threadA recive interrupt flag:" + Thread.currentThread().isInterrupted());
            System.out.println("threadA end time :" + System.currentTimeMillis());
        }, "threadA");
        Thread threadB = new Thread(() -> {
            System.out.println("threadB start time :" + System.currentTimeMillis());
            // 获得中断信号Thread.interrupted()为True
            while (!Thread.interrupted()) {

            }
            System.out.println("threadA end time :" + System.currentTimeMillis());
            // Thread.interrupted()对线程进行复位，变为FALSE
            System.out.println("threadB recive interrupt flag1:" + Thread.interrupted());
            // Thread.interrupted()对线程进行复位，变为FALSE
            System.out.println("threadB recive interrupt flag2:" + Thread.currentThread().isInterrupted());
        }, "threadB");
        Thread threadC = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    // 睡眠时被中断，抛出InterruptedException
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("threadC recive interrupt flag1:" + Thread.currentThread().isInterrupted());
                }
                catch (InterruptedException e) {
                    //在InterruptedException 抛出之前，JVM会先把线程的中断标识位清除。
                    //然后才会抛出 InterruptedException，这个时候如果调用 isInterrupted 方法，将会返回 false
                    System.out.println("threadC recive interrupt flag2:" + Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                    break;
                }
            }
            System.out.println("thread_end");
        }, "threadC");
        // 启动线程A
        threadA.start();
        TimeUnit.SECONDS.sleep(3);
        // 3s后发送线程中断指令
        threadA.interrupt();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("------------");
        threadB.start();
        TimeUnit.SECONDS.sleep(3);
        // 3s后发送线程中断指令
        threadB.interrupt();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("------------");
        threadC.start();
        TimeUnit.SECONDS.sleep(3);
        // 3s后发送线程中断指令
        threadC.interrupt();
    }
}
