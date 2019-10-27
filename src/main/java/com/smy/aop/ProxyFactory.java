package com.smy.aop;

/**
 * ProxyFactory
 * Created by shaomy on 2019/10/25/025.
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {
    @Override
    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    protected final AopProxy createAopProxy() {
        //如果这个类没有接口
        //return new Cglib2AopProxy(this);
        if (getTargetSource().getInterfaces() == null || getTargetSource().getInterfaces().length == 0) {
            return new CglibAopProxy(this);
        }
        return new JdkDynamicAopProxy(this);
    }
}
