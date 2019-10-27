package com.smy.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.Method;

/**
 * cglib动态代理
 * Created by shaomy on 2019/10/25/025.
 */
public class CglibAopProxy extends AbstractAopProxy {

    public CglibAopProxy(AdvisedSupport advised) {
        super(advised);
    }

    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(advised.getTargetSource().getTargetClass());
        enhancer.setInterfaces(advised.getTargetSource().getInterfaces());
        enhancer.setCallback(new DynamicAdvisedInterceptor(advised));
        Object obj = enhancer.create();
        return obj;
    }

    private static class DynamicAdvisedInterceptor implements net.sf.cglib.proxy.MethodInterceptor {

        private AdvisedSupport advisedSupport;
        private MethodInterceptor methodInterceptor;

        public DynamicAdvisedInterceptor(AdvisedSupport advisedSupport) {
            this.advisedSupport = advisedSupport;
            methodInterceptor = advisedSupport.getMethodInterceptor();
        }


        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            if (advisedSupport.getMethodMatcher() == null ||
                    advisedSupport.getMethodMatcher().
                            matches(method, advisedSupport.getTargetSource().getTargetClass())) {
                return methodInterceptor.invoke(new CglibMethodInvocation(advisedSupport.getTargetSource()
                        .getTarget(), method, objects, methodProxy));
            }
            return new CglibMethodInvocation(advisedSupport.getTargetSource().getTarget(), method, objects, methodProxy).proceed();
        }
    }

    private static class CglibMethodInvocation extends ReflectiveMethodInvocation {

        private final MethodProxy methodProxy;

        public CglibMethodInvocation(Object target, Method method, Object[] args, MethodProxy methodProxy) {
            super(target, method, args);
            this.methodProxy = methodProxy;
        }

        @Override
        public Object proceed() throws Throwable {
            return this.methodProxy.invoke(this.target, this.args);
        }
    }
}
