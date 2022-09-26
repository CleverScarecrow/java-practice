package com.scarecrow.concurrent.day03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangbo
 * @description
 * @date 2020/7/20
 */
public class VolatileSerialDemo {
    private static int x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> resutMap = new HashMap<>();
        Set<String> resutSet = new HashSet<>();
        for(int i = 0; i < 1000000; i++) {
            x = 0; y = 0;
            resutMap.clear();
            Thread one = new Thread(() -> {
                int a = y;
                x = 1;
                resutMap.put("a", a);
            });

            Thread two = new Thread(() -> {
                int b = x;
                y = 1;
                resutMap.put("b", b);
            });
            one.start();
            two.start();
            one.join();
            two.join();
            resutSet.add("a=" + resutMap.get("a") + "-" + "b=" + resutMap.get("b"));
            System.out.println(resutSet);
        }
    }
}
