package com.smy;

/**
 * beanDefiniation 定义了有关bean，beanClass BeanClassName等属性 相当于一个POJO
 * Created by shaomy on 2019/10/23/023.
 */
public class BeanDefinition {
    private Object bean;
    private Class beanCls;
    private String beanClsName;
    private PropertyValues propertyValues;

    public BeanDefinition() {
        propertyValues = new PropertyValues();
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanCls() {
        return beanCls;
    }

    public void setBeanCls(Class beanCls) {
        this.beanCls = beanCls;
    }

    public String getBeanClsName() {
        return beanClsName;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    /**
     * 这里实现通过类名来获取Class
     *
     * @param beanClsName
     */
    public void setBeanClsName(String beanClsName) {
        this.beanClsName = beanClsName;
        try {
            this.beanCls = Class.forName(beanClsName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
