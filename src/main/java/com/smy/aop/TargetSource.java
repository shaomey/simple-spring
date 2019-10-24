package com.smy.aop;

/**
 * 被代理对象
 * Created by shaomy on 2019/10/24/024.
 */
public class TargetSource {
    private Class targetClass;
    private Object target;

    public TargetSource(Class targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
