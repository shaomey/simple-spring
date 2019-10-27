package com.smy.aop;

import org.aopalliance.aop.Advice;

/**
 * 获取advice
 * Created by shaomy on 2019/10/25/025.
 */
public interface Advisor {
    Advice getAdvice();
}
