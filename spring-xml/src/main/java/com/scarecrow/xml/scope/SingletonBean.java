package com.scarecrow.xml.scope;

public class SingletonBean {

    private String desc;

    private PrototypeBean prototypeBean;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PrototypeBean getPrototypeBean() {
        return prototypeBean;
    }

    public void setPrototypeBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }
}
