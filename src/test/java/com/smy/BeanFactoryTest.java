package com.smy;

import com.smy.factory.AutowireCapableBeanFactory;
import com.smy.factory.BeanFactroy;
import org.junit.Test;

/**
 * Created by shaomy on 2019/10/23/023.
 */
public class BeanFactoryTest {
    @Test
    public void test() {
        BeanFactroy factroy = new AutowireCapableBeanFactory();
        BeanDefination beanDefination = new BeanDefination();
        beanDefination.setBeanClsName("com.smy.Person");
        factroy.registerBeanDefination("person", beanDefination);
        Person person = (Person) factroy.getBean("person");
        person.say();
    }
}
