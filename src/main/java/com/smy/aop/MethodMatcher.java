package com.smy.aop;

import java.lang.reflect.Method;

/**
 * 方法过滤器
 * Created by shaomy on 2019/10/25/025.
 */
public interface MethodMatcher {
    boolean matches(Method method, Class targetClass);
}
