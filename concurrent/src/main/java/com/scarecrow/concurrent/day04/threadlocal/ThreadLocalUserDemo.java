package com.scarecrow.concurrent.day04.threadlocal;

/**
 * @author wangbo
 * @description
 * @date 2020/8/14
 */
public class ThreadLocalUserDemo {

    private static final ThreadLocalUser loacl = new ThreadLocalUser();

    public static void main(String[] args) {
        System.out.println(loacl.get() );
    }
}
