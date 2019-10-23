package com.smy;

/**
 * 此类是用于处理xml中ref 因为引用的一定是个类 所以讲被引用的类用此类包装
 * Created by shaomy on 2019/10/23/023.
 */
public class BeanReference {
    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
