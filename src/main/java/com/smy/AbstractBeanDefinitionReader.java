package com.smy;

import com.smy.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象类
 * Created by shaomy on 2019/10/23/023.
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private Map<String, BeanDefinition> registry;
    private ResourceLoader resourceLoader;

    /**
     * registry 存储从xml中获取的beanDefination
     * @param resourceLoader {@link ResourceLoader}
     */
    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
