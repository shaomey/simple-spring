package com.smy.aop;

/**
 * PointCut方法
 * Created by shaomy on 2019/10/25/025.
 */
public interface PointCut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
