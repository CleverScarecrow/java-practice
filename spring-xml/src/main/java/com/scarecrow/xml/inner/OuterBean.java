package com.scarecrow.xml.inner;

/**
 * @author wangbo
 * @since 2022/10/20 14:23
 */
public class OuterBean {

    private String desc;

    private InnerBean innerBean;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public InnerBean getInnerBean() {
        return innerBean;
    }

    public void setInnerBean(InnerBean innerBean) {
        this.innerBean = innerBean;
    }

    @Override
    public String toString() {
        return "OuterBean{" +
                "desc='" + desc + '\'' +
                ", innerBean=" + innerBean +
                '}';
    }
}
