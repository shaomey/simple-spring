package com.smy.factory;

import com.smy.BeanDefination;

/**
 * beanFactory是注册BeanDefination; 创建，以及获取bean的类的接口
 * Created by shaomy on 2019/10/23/023.
 */
public interface BeanFactroy {
    Object getBean(String name);

    void registerBeanDefination(String name, BeanDefination beanDefination);
}
