package com.scarecrow.xml.parentContainer;

/**
 * @author wangbo
 * @since 2022/10/20 11:52
 */
public class ParentBean {

    private String parent;

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "ParentBean{" +
                "parent='" + parent + '\'' +
                '}';
    }
}
