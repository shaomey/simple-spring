package com.smy.context;

import com.smy.factory.AbstractBeanFactory;

/**
 * 抽象类
 * Created by shaomy on 2019/10/23/023.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactroy;

    public AbstractApplicationContext(AbstractBeanFactory beanFactroy) {
        this.beanFactroy = beanFactroy;
    }

    public void refersh() throws Exception {

    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactroy.getBean(name);
    }
}
