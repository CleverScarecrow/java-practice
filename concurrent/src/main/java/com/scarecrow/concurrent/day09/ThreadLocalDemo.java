package com.scarecrow.concurrent.day09;

public class ThreadLocalDemo {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<User> threadLocalUser = new ThreadLocal<>();
    public static void main(String args[]) {
        threadLocal.set(100);	// 保存值
        threadLocal.remove();
        threadLocal.set(100);	// 保存值
        System.out.println(threadLocal.get());	// 获取值
        User user = new User();
        user.setName("scarecrow");
        user.setAge(25);
        threadLocalUser.set(user);	// 保存值
        System.out.println(threadLocalUser.get());	// 获取值
    }


    static class User{
        String name;
        Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User [name=" + name + ", age=" + age + "]";
        }

    }
}
