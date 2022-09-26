package com.scarecrow.concurrent.day04.threadlocal;

/**
 * @author wangbo
 * @description
 * @date 2020/8/14
 */
public class ThreadLocalUser extends ThreadLocal<User>{

    @Override
    protected User initialValue() {
        return new User(99, "defaultUser");
    }
}
