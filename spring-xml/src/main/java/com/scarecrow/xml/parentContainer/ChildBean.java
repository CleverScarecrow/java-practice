package com.scarecrow.xml.parentContainer;

/**
 * @author wangbo
 * @since 2022/10/20 11:53
 */
public class ChildBean {

    private String child;

    private ParentBean parentBean;

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public ParentBean getParentBean() {
        return parentBean;
    }

    public void setParentBean(ParentBean parentBean) {
        this.parentBean = parentBean;
    }

    @Override
    public String toString() {
        return "ChildBean{" +
                "child='" + child + '\'' +
                ", parentBean=" + parentBean +
                '}';
    }
}
