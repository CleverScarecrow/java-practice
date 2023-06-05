package com.scarecrow.xml;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author wangbo
 * @since 2023/6/5 21:10
 */
public class TestXmlBeanFactory {

    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("contruct/TestBean.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        System.out.println(xmlBeanFactory.getBean("beanOne"));
    }
}
