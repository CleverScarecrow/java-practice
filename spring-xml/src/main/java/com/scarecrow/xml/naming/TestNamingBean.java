package com.scarecrow.xml.naming;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangbo
 * @since 2022/9/26 19:58
 */
public class TestNamingBean {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("naming/TestBean.xml");
        System.out.println(applicationContext.getBean("testBean"));
    }
}
