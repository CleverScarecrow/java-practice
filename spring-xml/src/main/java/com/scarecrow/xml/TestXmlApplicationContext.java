package com.scarecrow.xml;

import com.scarecrow.bean.TestBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangbo
 * @since 2022/9/26 19:58
 */
public class TestXmlApplicationContext {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("TestBean.xml");
        System.out.println(applicationContext.getBean(TestBean.class));
    }
}
