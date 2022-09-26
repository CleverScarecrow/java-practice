package com.scarecrow.concurrent.day05;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    private static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new ParkCar(), "车辆 " + i).start();
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }

    static class ParkCar implements Runnable {
        @Override
        public void run() {
            try {
                // 申请许可证类似于查看有无车位
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " 开始停车");
                // 模拟停车10s中
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 结束停车");
            // 释放许可证类似于车子驶离停车场，空出来了车位
            semaphore.release();
        }
    }
}
