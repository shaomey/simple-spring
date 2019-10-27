package com.smy.aop;

/**
 * 被代理对象
 * Created by shaomy on 2019/10/24/024.
 */
public class TargetSource {
    private Class<?> targetClass;
    private Class<?>[] interfaces;

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    private Object target;

    public TargetSource() {
    }

    public TargetSource(Object target, Class<?> targetClass, Class<?>... interfaces) {
        this.targetClass = targetClass;
        this.interfaces = interfaces;
        this.target = target;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
