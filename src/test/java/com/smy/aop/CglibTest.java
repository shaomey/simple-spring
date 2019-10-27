package com.smy.aop;

import com.smy.Person;
import org.junit.Test;

/**
 * cglibTest
 * Created by shaomy on 2019/10/26/026.
 */
public class CglibTest {

    @Test
    public void test() {
        TargetSource source = new TargetSource(new Person(), Person.class);
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(source);
        advisedSupport.setMethodInterceptor(new TestIntercepter());
        Person person = (Person) new CglibAopProxy(advisedSupport).getProxy();
        person.sayHello();
    }
}
