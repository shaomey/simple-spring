package com.smy;

/**
 * 这是AOP中的advise
 * Created by shaomy on 2019/10/24/024.
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
