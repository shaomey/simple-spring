package com.smy.factory;

/**
 * beanFactory是注册BeanDefination; 创建，以及获取bean的类的接口
 * Created by shaomy on 2019/10/23/023.
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;

}
