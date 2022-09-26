package com.scarecrow.springconfig;

import com.scarecrow.bean.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangbo
 * @since 2022/9/26 20:01
 */
public class TestJavaConfigApplicationContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestJavaConfiguration.class);
        System.out.println(applicationContext.getBean(TestBean.class));
    }
}
