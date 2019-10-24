package com.smy;

import com.smy.factory.AbstractBeanFactory;
import com.smy.factory.AutowireCapableBeanFactory;
import com.smy.io.ResourceLoader;
import com.smy.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * Test
 * Created by shaomy on 2019/10/23/023.
 */
public class BeanFactoryTest {
    @Test
    public void test1() throws Exception {
        ResourceLoader loader = new ResourceLoader();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(loader);
        reader.loadBeanDefination("test.xml");
        AbstractBeanFactory factory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinition : reader.getRegistry().entrySet()) {
            factory.registerBeanDefinition(beanDefinition.getKey(), beanDefinition.getValue());
        }
        Person person = (Person) factory.getBean("person");
        School school = (School) factory.getBean("school");
        person.sayHeight();
        school.print();
    }
}
