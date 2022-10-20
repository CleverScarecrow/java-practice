package com.scarecrow.xml.inner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangbo
 * @since 2022/10/20 14:25
 */
public class TestInnerBean {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("inner/innerBean.xml");
        System.out.println(applicationContext.getBean(OuterBean.class));
        applicationContext.close();
    }
}
