package com.smy.factory;

import com.smy.BeanDefinition;
import com.smy.BeanReference;
import com.smy.PropertyValue;
import com.smy.annotation.Autowired;
import convert.ConverterFactory;

import java.lang.reflect.Field;

/**
 * beanFactory实现类 实现了CreateBean方法
 * Created by shaomy on 2019/10/23/023.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {


    protected void injectAnnotation(Object bean) throws Exception {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            Autowired autowired = field.getAnnotation(Autowired.class);
            if (autowired == null) {
                continue;
            }
            field.setAccessible(true);
            field.set(bean, getBean(field.getName()));
        }
    }


    /**
     * 使用newInstance获取类实例
     *
     * @param beanDefinition
     * @return
     */
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        try {
            Object bean = createBeanInstancce(beanDefinition);
            beanDefinition.setBean(bean);
            applyPropertyValues(bean, beanDefinition);
            injectAnnotation(bean);
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected Object createBeanInstancce(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanCls().newInstance();
    }

    public void preInit() {

    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                value = getBean(((BeanReference) value).getName());
            } else {
                if (declaredField.getType().toString().equals("class java.lang.String")) {
                    declaredField.set(bean, value);
                    continue;
                } else {
                    value = ConverterFactory.getConverterMap().get(declaredField.getType()).convertParameter((String) value);
                }
            }
            declaredField.set(bean, value);
        }
    }

}
