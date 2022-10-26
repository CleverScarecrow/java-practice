package com.scarecrow.xml.autowiring;

import java.util.HashMap;
import java.util.List;

/**
 * @author wangbo
 * @since 2022/10/26 9:24
 */
public class FirstAutowireBean {

    private String desc;

    private List<Integer> list;

    private HashMap<Integer, Integer> map;

    private SecondAutowireBean secondAutowireBean;

    private ThirdAutowireBean thirdAutowireBean;

    public FirstAutowireBean() {

    }

    public FirstAutowireBean(SecondAutowireBean secondAutowireBean, ThirdAutowireBean thirdAutowireBean, List<Integer> list, HashMap<Integer, Integer> map) {
        this.secondAutowireBean = secondAutowireBean;
        this.thirdAutowireBean = thirdAutowireBean;
        this.list = list;
        this.map = map;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public HashMap<Integer, Integer> getMap() {
        return map;
    }

    public void setMap(HashMap<Integer, Integer> map) {
        this.map = map;
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
                ", list=" + list +
                ", map=" + map +
                ", secondAutowireBean=" + secondAutowireBean +
                ", thirdAutowireBean=" + thirdAutowireBean +
                '}';
    }
}
