package com.scarecrow.xml.scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

/**
 *
 * Singleton Beans with Prototype-bean Dependencies（单例Bean注入原型Bean为同一个，若要不同 可以使用Method Injection）
 * @author wangbo
 * @since 2022/9/26 19:58
 */
public class TestScopeBean {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("scope/scopeBean.xml");
        SingletonBean singletonBean = applicationContext.getBean(SingletonBean.class);
        SingletonBean singletonBean1 = applicationContext.getBean(SingletonBean.class);
        Assert.isTrue(singletonBean == singletonBean1, "单例Bean形同");
        Assert.isTrue(singletonBean.getPrototypeBean() == singletonBean1.getPrototypeBean(), "单例Bean 注入的原型Bean也是形同");
        PrototypeBean prototypeBean = applicationContext.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean1 = applicationContext.getBean(PrototypeBean.class);
        Assert.isTrue(prototypeBean != prototypeBean1, "原型bean不相同");
        // todo 原型Bean的生命周期


    }
}
