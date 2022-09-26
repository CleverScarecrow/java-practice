package com.scarecrow.concurrent.day06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wangbo
 * @description
 * @date 2020/10/12
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>(16, 0.5f);
        hashMap.put("1", 1);
        hashMap.put("2", 2);
        hashMap.put("3", 3);
        System.out.println("get---" + hashMap.get("1"));
        System.out.println("containsKey---" + hashMap.containsKey("1"));
        System.out.println("containsValue---" + hashMap.containsValue(1));

        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        System.out.println("---entrySet---");
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println("key : " + next.getKey() + " value : " + next.getValue());
        }
        System.out.println("---entrySet---");
        System.out.println("---forEach---");
        hashMap.forEach((key, value) -> System.out.println("key : " + key + " value : " + value));
        System.out.println("---forEach---");
        System.out.println("getOrDefault---" + hashMap.getOrDefault("4", 4));
        System.out.println("isEmpty---" + hashMap.isEmpty());
        // 当map中不存在指定的key时，便将传入的value设置为key的值，相当于map.put(key, value)；并返回value
        // 当key存在值时，执行一个方法该方法接收key的旧值和传入的value，执行自定义的方法返回最终结果设置为key的值。
        System.out.println("---merge---");
        System.out.println(hashMap.merge("4", 4, (o1, o2) -> o1 + o2));
        System.out.println(hashMap.get("4"));
        System.out.println("---------");
        System.out.println(hashMap.merge("4", 5, (old, ne) -> ne + old));
        System.out.println(hashMap.get("4"));
        System.out.println("---merge---");
        System.out.println("---remove---");
        hashMap.remove("4");
        hashMap.remove("3", 33);
        hashMap.forEach((key, value) -> System.out.println("key : " + key + " value : " + value));
        System.out.println("---remove---");
        System.out.println("---replace---");
        hashMap.replace("1", 11);
        hashMap.replace("2", 2, 22);
        // 所有元素在原有基础上加100
        hashMap.replaceAll((o1, o2) -> hashMap.get(o1) + 100);
        hashMap.forEach((key, value) -> System.out.println("key : " + key + " value : " + value));
        System.out.println("---replace---");
        System.out.println("---putIfAbsent---");
        // 返回key为4的原有值null
        System.out.println(hashMap.putIfAbsent("4", 4));
        System.out.println(hashMap.putIfAbsent("4", 44));
        // key为4的value为4，存在不会更新为44。
        System.out.println(hashMap.get("4"));
        System.out.println("---putIfAbsent---");
        System.out.println("---compute---");
        hashMap.forEach((key, value) -> System.out.println("key : " + key + " value : " + value));
        System.out.println("---");
        // o1为key:3，o2为3的oldValue。把key为3的value更新为原来的2倍
        hashMap.compute("3", (o1, o2) -> hashMap.get(o1) + o2);
        hashMap.forEach((key, value) -> System.out.println("key : " + key + " value : " + value));
        System.out.println("---");
        // key为4 的value存在。不会计算更新
        hashMap.computeIfAbsent("4", key -> hashMap.get(key) + 140);
        // key为5 的value不存在。会计算更新
        hashMap.computeIfAbsent("5", key -> hashMap.get("4") + 151);
        hashMap.forEach((key, value) -> System.out.println("key : " + key + " value : " + value));
        System.out.println("---");
        // key为4 的value存在。才会计算更新
        hashMap.computeIfPresent("4", (key, oldValue) -> hashMap.get(key) + oldValue + 140);
        // key为6 的value不存在。不会计算更新
        hashMap.computeIfPresent("6", (key, oldValue) -> oldValue + 160);
        hashMap.forEach((key, value) -> System.out.println("key : " + key + " value : " + value));
        System.out.println("---compute---");
    }

    /**
     * 计算单词出现的次数存到hashMap中
     */
    public static void useMerge() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> words = Arrays.asList("Foo", "Bar", "Foo", "Buzz", "Foo", "Buzz", "Fizz", "Fizz");
        words.forEach(word -> {
            hashMap.merge(word, 1, (oldCount, newCount) -> oldCount + newCount);
        });
        System.out.println(hashMap);
    }

    /**
     * 计算单词出现的次数存到hashMap中
     */
    public static void testPutIfAbsent() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> words = Arrays.asList("Foo", "Bar", "Foo", "Buzz", "Foo", "Buzz", "Fizz", "Fizz");
        words.forEach(word -> {
            hashMap.putIfAbsent(word, 0);
            hashMap.put(word, hashMap.get(word) + 1);
        });
        System.out.println(hashMap);
    }

    /**
     * 计算单词出现的次数存到hashMap中
     */
    public static void testComputeIfPresent() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> words = Arrays.asList("Foo", "Bar", "Foo", "Buzz", "Foo", "Buzz", "Fizz", "Fizz");
        words.forEach(word -> {
            hashMap.putIfAbsent(word, 0);
            hashMap.computeIfPresent(word, (key, oldValue) -> oldValue + 1);
        });
        System.out.println(hashMap);
    }

}
