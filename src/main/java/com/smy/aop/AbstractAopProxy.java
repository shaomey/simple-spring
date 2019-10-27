package com.smy.aop;

/**
 * 抽象代理类
 * Created by shaomy on 2019/10/25/025.
 */
public abstract class AbstractAopProxy implements AopProxy {
    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
