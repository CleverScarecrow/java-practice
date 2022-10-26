package com.scarecrow.xml.autowiring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * autowire attribute的使用
 *
 * <a href="https://docs.spring.io/spring-framework/docs/5.2.12.RELEASE/spring-framework-reference/core.html#beans-factory-autowire">...</a>
 * </pre>
 *
 * @author wangbo
 * @since 2022/10/26 9:26
 */
public class TestAutowire {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("autowiring/AutowireBean.xml");
        System.out.println(applicationContext.getBean(FirstAutowireBean.class));
    }

}
