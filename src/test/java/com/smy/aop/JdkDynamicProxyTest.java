package com.smy.aop;

import com.smy.Chinese;
import com.smy.Subject;
import com.smy.context.ApplicationContext;
import com.smy.context.ClasspathXmlApplicationContext;
import org.junit.Test;

/**
 * Test
 * Created by shaomy on 2019/10/24/024.
 */
public class JdkDynamicProxyTest {
    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClasspathXmlApplicationContext("test.xml");
        Subject subject = (Chinese) applicationContext.getBean("chinese");
        subject.sayName();
        TestIntercepter testIntercepter = new TestIntercepter();
        TargetSource source = new TargetSource(Subject.class, subject);
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(source);
        advisedSupport.setMethodInterceptor(testIntercepter);
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        Subject subject1 = (Subject) jdkDynamicAopProxy.getProxy();
        subject1.sayName();

    }
}
