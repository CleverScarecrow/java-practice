package com.scarecrow.xml.inner;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author wangbo
 * @since 2022/10/20 14:23
 */
public class InnerBean implements InitializingBean {

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "InnerBean{" +
                "desc='" + desc + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("innerBean afterPropertiesSet");
    }

    public void destroy() {
        System.out.println("innerBean destroy");
    }
}
