package com.scarecrow.xml.scope;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

/**
 *
 * Singleton Beans with Prototype-bean Dependencies（单例Bean注入原型Bean为同一个，若要不同 可以使用Method Injection）
 * @author wangbo
 * @since 2022/9/26 19:58
 */
public class TestScopeBean {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("scope/scopeBean.xml");
        SingletonBean singletonBean1 = applicationContext.getBean("singletonBean1", SingletonBean.class);
        SingletonBean singletonBean1_1 = applicationContext.getBean("singletonBean1", SingletonBean.class);
        SingletonBean singletonBean2 = applicationContext.getBean("singletonBean2",SingletonBean.class);
        Assert.isTrue(singletonBean1 == singletonBean1_1, "单例Bean形同");
        Assert.isTrue(singletonBean1.getPrototypeBean() == singletonBean1_1.getPrototypeBean(), "单例Bean 注入的原型Bean也是相同");
        Assert.isTrue(singletonBean1.getPrototypeBean() != singletonBean2.getPrototypeBean(), "不同的单例Bean 注入的原型Bean也不相同");
        PrototypeBean prototypeBean = applicationContext.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean1 = applicationContext.getBean(PrototypeBean.class);
        Assert.isTrue(prototypeBean != prototypeBean1, "原型bean不相同");
    }

    @Test
    public void prototypeBeanLifeCycle() {
        // 原型Bean的生命周期



    }
}
