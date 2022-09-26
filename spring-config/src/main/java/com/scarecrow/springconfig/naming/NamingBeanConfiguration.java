package com.scarecrow.springconfig.naming;

import com.scarecrow.bean.naming.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangbo
 * @since 2022/9/26 20:01
 */
@Configuration
public class NamingBeanConfiguration {

    @Bean
    public TestBean testBean() {
        TestBean testBean = new TestBean();
        testBean.setName("testBean");
        return testBean;
    }
}
