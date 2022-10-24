package com.scarecrow.xml.lazy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangbo
 * @since 2022/10/24 11:45
 */
public class TestLazyBean {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("lazy/lazyBean.xml");
        System.out.println("------------");
        applicationContext.getBean(LazyBean.class);
    }
}
