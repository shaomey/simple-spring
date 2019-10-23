package com.smy.factory;

import com.smy.BeanDefinition;

/**
 * beanFactory是注册BeanDefination; 创建，以及获取bean的类的接口
 * Created by shaomy on 2019/10/23/023.
 */
public interface BeanFactroy {
    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
