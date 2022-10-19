package com.scarecrow.xml.construct;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangbo
 * @since 2022/10/19 11:12
 */
public class TestConstructorInjection {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("contruct/TestBean.xml");
        System.out.println(applicationContext.getBean("beanOne"));
    }
}
