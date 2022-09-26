package com.scarecrow.springconfig;

import com.scarecrow.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangbo
 * @since 2022/9/26 20:01
 */
@Configuration
public class TestJavaConfiguration {

    @Bean
    public TestBean testBean() {
        TestBean testBean = new TestBean();
        testBean.setName("testBean");
        return testBean;
    }
}
