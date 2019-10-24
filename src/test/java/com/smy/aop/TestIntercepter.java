package com.smy.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * test拦截器
 * Created by shaomy on 2019/10/24/024.
 */
public class TestIntercepter implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(methodInvocation.getThis().getClass().getSimpleName() + " start before!");
        methodInvocation.proceed();
        System.out.println(methodInvocation.getThis().getClass().getSimpleName() + " start after!");
        return methodInvocation.getThis();
    }
}
