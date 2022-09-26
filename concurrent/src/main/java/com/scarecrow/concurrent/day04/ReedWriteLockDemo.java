package com.scarecrow.concurrent.day04;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangbo
 * @description:读读不互斥，写读互斥，读写互斥，写写互斥
 * 锁重入：1、读线程获取读锁之后能够再次获取读锁
 *       2、写线程获取写锁之后能再次获取写锁。
 *       3、写线程获取写锁之后获取读锁（锁降级）。
 *       4、读线程获取读锁之后不能够再次获取写锁。
 * 读锁释放：如果一下个节点继续是读锁的申请，只要成功获取，就再下一个节点，直到队列尾部或为写锁的申请，停止传播
 * @date 2020/8/3
 */
public class ReedWriteLockDemo {

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        Thread myWriteLockA = new Thread(new MyWriteLock(writeLock), "myWriteLockA");
        Thread myReadLockB = new Thread(new MyReadLock(readLock), "myReadLockB");
        Thread myReadLockC = new Thread(new MyReadLock(readLock), "myReadLockC");
        Thread myWriteLockD = new Thread(new MyWriteLock(writeLock), "myWriteLockD");
        Thread myReadLockE = new Thread(new MyReadLock(readLock), "myReadLockE");

        myWriteLockA.start();
        TimeUnit.MILLISECONDS.sleep(100);
        myReadLockB.start();
        TimeUnit.MILLISECONDS.sleep(100);
        myReadLockC.start();
        TimeUnit.MILLISECONDS.sleep(100);
        myWriteLockD.start();
        TimeUnit.MILLISECONDS.sleep(100);
        myReadLockE.start();
    }

    static class MyReadLock extends Thread {

        private ReentrantReadWriteLock.ReadLock readLock;

        public MyReadLock(ReentrantReadWriteLock.ReadLock readLock) {
            this.readLock = readLock;
        }

        @Override
        public void run() {
            readLock.lock();
            System.out.println("read---lock---start :" + Thread.currentThread() + " ：：：" + System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            readLock.unlock();
            System.out.println("read---lock---end :" + Thread.currentThread() + " ：：：" + System.currentTimeMillis());
        }
    }

    static class MyWriteLock extends Thread{

        private ReentrantReadWriteLock.WriteLock writeLock;

        public MyWriteLock(ReentrantReadWriteLock.WriteLock writeLock) {
            this.writeLock = writeLock;
        }

        @Override
        public void run() {
            writeLock.lock();
            System.out.println("write---lock---start :" + Thread.currentThread() + " ：：：" + System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            writeLock.unlock();
            System.out.println("write---lock---end :" + Thread.currentThread() + " ：：：" + System.currentTimeMillis());
        }
    }
}
