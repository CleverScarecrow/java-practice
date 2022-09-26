package com.scarecrow.concurrent.day07;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author wangbo
 * @description
 * @date 2020/11/23
 */
public class ArrayBlockingQueueDemo {
    private static ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(2);

    private static ArrayBlockingQueue<Integer> consumeQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        useDemo();
        consumeDemo();
    }

    private static void consumeDemo() throws InterruptedException {
        Thread consume = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("等待消费");
                    Integer a = consumeQueue.take();
                    System.out.println("消费：" + a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread product = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    consumeQueue.put(i);
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consume.start();
        TimeUnit.SECONDS.sleep(5);
        product.start();
    }

    private static void useDemo() throws InterruptedException {
        // 添加一个元素，成功返回true，如果空间满了则抛出异常
        arrayBlockingQueue.add(1);
        // 添加一个元素，成功返回true，如果空间满了则返回false,处理有界队列时优于add方法
        arrayBlockingQueue.offer(2);
        // 添加一个元素，成功返回true，**如果空间满了则阻塞指定时间**，到达指定时间还没空间则返回false
        arrayBlockingQueue.offer(3, 20, TimeUnit.SECONDS);
        // 添加一个元素，成功返回true，**如果空间满了则阻塞等待**
        arrayBlockingQueue.put(4);
        // 检索并移除队列头元素，成功则返回移除的元素，如果队列为空则抛出异常
        arrayBlockingQueue.remove();
        // 检索并移除队列头元素，成功则返回移除的元素，如果队列为空则返回null
        arrayBlockingQueue.poll();
        // 检索并移除队列头元素，成功则返回移除的元素，如果队列为空则阻塞指定时间，到达指定时间后队列还是空则返回null
        arrayBlockingQueue.poll(10, TimeUnit.SECONDS);
        // 检索并返回队列头元素，如果队列为空则抛出异常
        arrayBlockingQueue.element();
        // 检索并返回队列头元素，如果位列为空则返回null
        arrayBlockingQueue.peek();
        // 检索并移除队列头元素，成功则返回移除的元素，如果队列为空则阻塞
        arrayBlockingQueue.take();
    }

}
