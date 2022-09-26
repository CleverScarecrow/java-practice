package com.scarecrow.concurrent.day01;

import java.util.concurrent.TimeUnit;

/**
 * 6-5
 */
public class DaemonDemo {

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("DaemonThread start run.");
                TimeUnit.SECONDS.sleep(10);
                // 主线程1s后终止，此时没有非Daemon线程，Daemon线程也会立即终止，此行输出不会打印
                System.out.println("DaemonThread end run.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new DaemonRunner(),"daemon_thread");
        // 设置线程daemon_thread为Daemon
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(1);
    }
}
