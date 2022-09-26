package com.scarecrow.concurrent.day02;

/**
 * javap -v
 * 3: monitorenter
 * 4: aload_2
 * 5: monitorexit
 */
public class MonitorDemo {

    public void demo(Object lock) {
        synchronized (lock) {

        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        MonitorDemo monitorDemo = new MonitorDemo();
        new Thread(() -> monitorDemo.demo(lock)).start();
    }
}
