package com.scarecrow.concurrent.day03;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

/**
 * @author wangbo
 * @description
 * @date 2020/7/20
 */
public class HappensBeforeDemo {
    private static int happenFlag = 0;

    private static int a = 0, b = 0;
    private static int x = 0, y = 0;

    public static void main(String[] args) throws Exception {

    }

    public static void threadStartHappensTest1() throws Exception {
        Thread threadA = new Thread(() -> {
            try {
                while (true) {
                    // 不能使用sout打印，sout中有同步锁
                    Assert.assertTrue(happenFlag == 0);
                    if (happenFlag == 10) {
                        break;
                    }
                }
                System.out.println("threadA end");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadA.start();
        TimeUnit.MILLISECONDS.sleep(100);
        happenFlag = 10;
    }

    // thread.start happens-before
    public static void threadStartHappensTest2() throws Exception {
        Thread threadA = new Thread(() -> {
            try {
                while (true) {
                    Assert.assertTrue(happenFlag == 10);
                    if (happenFlag == 10) {
                        break;
                    }
                }
                System.out.println("threadA end");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
        happenFlag = 10;
        threadA.start();
    }
}
