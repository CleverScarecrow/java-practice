package com.scarecrow.concurrent.day04.threadlocal;

/**
 * @author wangbo
 * @description
 * @date 2020/8/14
 */
public class ThreadLocalDemo {

    private static final ThreadLocal<User> local = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            local.set(new User(1,"A"));
            System.out.println("threadA---" + local.get());
        }, "threadA").start();

        new Thread(() -> {
            local.set(new User(1,"B"));
            System.out.println("threadB---" + local.get());
        }, "threadB").start();

        local.set(new User(1,"Main"));
        System.out.println("threadMain---" + local.get());
    }
}
