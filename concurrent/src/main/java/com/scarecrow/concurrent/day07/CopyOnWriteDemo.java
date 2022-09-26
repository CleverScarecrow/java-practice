package com.scarecrow.concurrent.day07;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(2,22);
        System.out.println(list);
    }
}
