package com.scarecrow.concurrent.day02;

import org.openjdk.jol.info.ClassLayout;

public class MarkWordDemo {

    public static void main(String[] args) throws InterruptedException {
        // -XX:-UseBiasedLocking
        Object object = new Object();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        System.out.println("-----------------");
        synchronized (object) {
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
        }
    }
}
