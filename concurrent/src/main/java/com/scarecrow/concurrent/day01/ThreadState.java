package com.scarecrow.concurrent.day01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/***
 * 1、jps -l获取进程ID
 * 2、jstack pid打印堆栈信息
 *
 * */
public class ThreadState {

    public static void main(String[] args) {
        Object object = new Object();
        ReentrantLock reentrantLock = new ReentrantLock();
        //waiting状态
        new Thread(new Waitting(), "WaittingThread").start();
        //time_waiting状态
        new Thread(new TimeWaitting(), "TimeWaitting").start();
        //time_waiting状态（获得锁）
        new Thread(new Blocked(object), "Blocked---Waitting").start();
        //blocked状态（无法获得锁）
        new Thread(new Blocked(object), "Blocked---Blocked").start();
        //time_waiting状态（获得锁）
        new Thread(new Lock(reentrantLock), "Lock---Waitting").start();
        //waiting状态，无法获取锁，不是blocked状态而是waiting状态与locksupport有关
        new Thread(new Lock(reentrantLock), "Lock---Blocked").start();
    }


    // WAITTING
    static class Waitting implements Runnable {
        @Override
        public void run() {
            while (true) {
                Object o = new Object();
                synchronized (o) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // TIMEWAITTING
    static class TimeWaitting implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // BLOCKED
    static class Blocked implements Runnable {
        private Object object;

        public Blocked(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            synchronized (object) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // LOCK
    static class Lock implements Runnable {
        private ReentrantLock reentrantLock;

        public Lock(ReentrantLock reentrantLock) {
            this.reentrantLock = reentrantLock;
        }

        @Override
        public void run() {
            reentrantLock.lock();
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
