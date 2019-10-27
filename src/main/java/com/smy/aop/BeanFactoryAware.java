package com.smy.aop;

import com.smy.factory.BeanFactory;

/**
 * Created by shaomy on 2019/10/25/025.
 */
public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
