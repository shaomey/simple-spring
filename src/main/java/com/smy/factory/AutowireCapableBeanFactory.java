package com.smy.factory;

import com.smy.BeanDefination;

/**
 * beanFactory实现类 实现了CreateBean方法
 * Created by shaomy on 2019/10/23/023.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     * 使用newInstance获取类实例
     * @param beanDefination
     * @return
     */
    @Override
    protected Object doCreateBean(BeanDefination beanDefination) {
        try {
            Object bean = beanDefination.getBeanCls().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
