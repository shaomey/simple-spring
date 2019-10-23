package com.smy;

/**
 * 加载beanDefination(这里表示从xml中)
 * Created by shaomy on 2019/10/23/023.
 */
public interface BeanDefinitionReader {
    void loadBeanDefination(String location) throws Exception;
}
