package com.scarecrow.xml.parentContainer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangbo
 * @since 2022/10/20 13:35
 */
public class TestParentContainer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext parentApplicationContext = new ClassPathXmlApplicationContext("parentContainer/parentBean.xml");
        ClassPathXmlApplicationContext childApplicationContext = new ClassPathXmlApplicationContext(new String[]{"parentContainer/childBean.xml"}, parentApplicationContext);
        System.out.println(childApplicationContext.getBean(ChildBean.class));
    }
}
