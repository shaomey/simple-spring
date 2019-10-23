package com.smy.factory;

import com.smy.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * beanFactory抽象类，定义了beanDefination容器
 * Created by shaomy on 2019/10/23/023.
 */
public abstract class AbstractBeanFactory implements BeanFactroy {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition != null) {
            Object bean = beanDefinition.getBean();
            if (bean == null) {
                bean = doCreateBean(beanDefinition);
            }
            return bean;
        }
        throw new IllegalArgumentException("No bean named " + name + " is defined");
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
