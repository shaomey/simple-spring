package com.smy.factory;

import com.smy.BeanDefination;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * beanFactory抽象类，定义了beanDefination容器
 * Created by shaomy on 2019/10/23/023.
 */
public abstract class AbstractBeanFactory implements BeanFactroy {
    private Map<String, BeanDefination> beanDefinationMap = new ConcurrentHashMap<String, BeanDefination>();

    @Override
    public Object getBean(String name) {
        return beanDefinationMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefination(String name, BeanDefination beanDefination) {
        Object bean = doCreateBean(beanDefination);
        beanDefination.setBean(bean);
        beanDefinationMap.put(name, beanDefination);
    }

    protected abstract Object doCreateBean(BeanDefination beanDefination);
}
