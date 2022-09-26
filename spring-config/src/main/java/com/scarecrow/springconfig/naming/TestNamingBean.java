package com.scarecrow.springconfig.naming;

import com.scarecrow.bean.naming.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangbo
 * @since 2022/9/26 20:01
 */
public class TestNamingBean {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(NamingBeanConfiguration.class);
        System.out.println(applicationContext.getBean(TestBean.class));
    }
}
