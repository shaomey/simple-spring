package com.smy.factory;

import com.smy.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * beanFactory抽象类，定义了beanDefination容器
 * Created by shaomy on 2019/10/23/023.
 */
public abstract class AbstractBeanFactory implements BeanFactroy {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
    private List<String> beanDefinitionNames = new ArrayList<>();

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

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void preInitBeans() throws Exception {
        for (String beanDefinitionName : beanDefinitionNames) {
            getBean(beanDefinitionName);
        }
    }

    public List<Object> getBeansForType(Class type) throws Exception {
        List<Object> beans = new ArrayList<Object>();
        for (String beanDefinitionName : beanDefinitionNames) {
            //a.isAssignableForm(b):a是否是b的同类或父类，类似b instanceof a。但是isAssignableFrom是类与类的关系，instanceof是实例与实例的
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanCls())) {
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
