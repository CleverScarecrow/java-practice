package com.scarecrow.concurrent.day10;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 验证线程状态
 * 1、Running（接受新任务并处理排队的任务）
 * 2、shutdown（不接受新任务，但处理排队的任务。）
 * 3、Stop（不接受新任务，不处理排队的任务，并中断正在进行的任务。执行shutdownNow方法）
 * 4、Tidying（所有任务都已终止，workerCount 为零，线程转换到 TIDYING 状态将运行 terminated() 钩子方法）
 * 5、Terminated（terminated() 已完成）
 */
public class ThreadPoolExecutorLifeDemo {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
            100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));

    /**
     * 任务1-5使用corePoolSize5个核心线程处理
     * 任务6-7加入阻塞队列等待处理（任务1-2执行完毕后的核心线程会处理任务6-7）
     * 任务8-10会在启动两个新的线程进行处理（此时的开启的线程数为7，并没有达到10）
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 11; i++) {
            executor.execute(new ExecutorTask(i, false));
            TimeUnit.MILLISECONDS.sleep(1);
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println("executorQueue---" + executor.getQueue().size());
        // 不接受新任务，但处理排队的任务
        executor.shutdown();
        // 不接受新任务，不处理排队的任务。正在执行的任务会发出中断interrupt信号。如果Task不处理interrupt，则线程不会停止
        // executor.shutdownNow();
        // 线程池是否关闭(true)
        System.out.println("isShutDown---" + executor.isShutdown());
        // 执行Shutdown()与ShutdownNow(),线程池不在接受新任务。使用拒绝策略处理（rejectedExecutionHandler）
        // executor.execute(new ExecutorTask(100, false));
        // 线程池是否正在终止(true)
        System.out.println("isTerminating---" + executor.isTerminating());
        // 线程池是否已经终止(false)
        System.out.println("isTerminated---" + executor.isTerminated());
        TimeUnit.SECONDS.sleep(30);
        // 线程池是否正在终止(false)
        System.out.println("isTerminating---" + executor.isTerminating());
        // 线程池是否已经终止(true)
        System.out.println("isTerminated---" + executor.isTerminated());
    }

    static class ExecutorTask implements Runnable {
        private int threadNum;

        private boolean isShutdownNow;

        public ExecutorTask(int threadNum, boolean isShutdownNow) {
            this.threadNum = threadNum;
            this.isShutdownNow = isShutdownNow;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "---threadStart---" + threadNum);
            // 验证shutdownNow()
            if (isShutdownNow) {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + "---threadShutdownNow---" + threadNum);
                        break;
                    }
                }
            }
            // 验证shutdown()
            else {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    // 什么都不做
                }
            }
            System.out.println(Thread.currentThread().getName() + "---threadEnd---" + threadNum);
        }
    }

}
