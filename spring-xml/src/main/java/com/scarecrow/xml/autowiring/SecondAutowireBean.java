package com.scarecrow.xml.autowiring;

/**
 * @author wangbo
 * @since 2022/10/26 9:25
 */
public class SecondAutowireBean {

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SecondAutowireBean{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
