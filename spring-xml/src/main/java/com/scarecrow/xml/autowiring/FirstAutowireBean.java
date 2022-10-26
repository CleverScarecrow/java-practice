package com.scarecrow.xml.autowiring;

/**
 * @author wangbo
 * @since 2022/10/26 9:24
 */
public class FirstAutowireBean {

    private String desc;

    private SecondAutowireBean secondAutowireBean;

    private ThirdAutowireBean thirdAutowireBean;

//    public FirstAutowireBean() {
//
//    }

    public FirstAutowireBean(SecondAutowireBean secondAutowireBean, ThirdAutowireBean thirdAutowireBean) {
        this.secondAutowireBean = secondAutowireBean;
        this.thirdAutowireBean = thirdAutowireBean;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public SecondAutowireBean getSecondAutowireBean() {
        return secondAutowireBean;
    }

    public void setSecondAutowireBean(SecondAutowireBean secondAutowireBean) {
        this.secondAutowireBean = secondAutowireBean;
    }

    public ThirdAutowireBean getThirdAutowireBean() {
        return thirdAutowireBean;
    }

    public void setThirdAutowireBean(ThirdAutowireBean thirdAutowireBean) {
        this.thirdAutowireBean = thirdAutowireBean;
    }

    @Override
    public String toString() {
        return "FirstAutowireBean{" +
                "desc='" + desc + '\'' +
                ", secondAutowireBean=" + secondAutowireBean +
                ", thirdAutowireBean=" + thirdAutowireBean +
                '}';
    }
}
