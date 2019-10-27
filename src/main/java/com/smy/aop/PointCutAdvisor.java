package com.smy.aop;

/**
 *
 * Created by shaomy on 2019/10/25/025.
 */
public interface PointCutAdvisor extends Advisor {
    PointCut getPointcut();
}
