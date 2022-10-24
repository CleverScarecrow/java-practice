package com.scarecrow.xml.lazy;

/**
 * @author wangbo
 * @since 2022/10/24 11:43
 */
public class NotLazyBean {
    private String desc;

    private LazyBean lazyBean;

    public NotLazyBean() {
        System.out.println("Not LazyBean Constructor");
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LazyBean getLazyBean() {
        return lazyBean;
    }

    public void setLazyBean(LazyBean lazyBean) {
        this.lazyBean = lazyBean;
    }
}
