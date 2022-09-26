package com.scarecrow.concurrent.day06;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    // 将hashmap初始容量设置为最终的容量，这样就不会调用resize方法
    // 32768*0.75=24576, 10000个数据不会扩容
    private static HashMap<String, Integer> hashMap = new HashMap<>(2 << 14);
    private static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>(2 << 14);

    public static void main(String[] args) throws InterruptedException {
        concurrentHashMap.put("1", 1);
        PutThread putThread = new PutThread();
        putThread.start();
        putThread.join();
        System.out.println("putThread run end");
        System.out.println("hashMapCount:" + hashMap.size());
    }

    static class PutThread extends Thread {
        @Override
        public void run() {
            // 2个线程同时向HashMap插入数据，每个线程插入5000条
            Thread threadA = new Thread(() -> {
                for (int j = 0; j < 5000; j++) {
                    hashMap.put(j + "_A", j);
                }
            });
            Thread threadB = new Thread(() -> {
                for (int j = 0; j < 5000; j++) {
                    hashMap.put(j + "_B", j);
                }
            });
            threadA.start();
            threadB.start();
            try {
                threadA.join();
                threadB.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
