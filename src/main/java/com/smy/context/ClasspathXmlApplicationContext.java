package com.smy.context;

import com.smy.AbstractBeanDefinitionReader;
import com.smy.BeanDefinition;
import com.smy.BeanPostProcessor;
import com.smy.annotation.parser.AnnotationParser;
import com.smy.factory.AbstractBeanFactory;
import com.smy.factory.AutowireCapableBeanFactory;
import com.smy.io.ResourceLoader;
import com.smy.xml.XmlBeanDefinitionReader;
import convert.Converter;
import convert.ConverterFactory;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 实现reFresh方法 此方法实现了对beanFactory中的beanDefinitionMap的注入
 * Created by shaomy on 2019/10/23/023.
 */
public class ClasspathXmlApplicationContext extends AbstractApplicationContext {
    private String configLocation;

    public ClasspathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refersh();
        resigterConverter(beanFactory);
        registerBeanPostProcessor(beanFactory);

    }

    public ClasspathXmlApplicationContext(String configLocation) throws Exception {
        this(new AutowireCapableBeanFactory(), configLocation);
    }

    public void resigterConverter(AbstractBeanFactory beanFactory) throws Exception {
        List<Object> converters = beanFactory.getBeansForType(Converter.class);
        for (Object converter : converters) {
            Type type = ((Converter) converter).getType();
            ConverterFactory.getConverterMap().put(type, (Converter) converter);
        }
    }

    public void registerBeanPostProcessor(AbstractBeanFactory beanFactory) throws Exception {
        List<Object> list = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object o : list) {
            beanFactory.addPostProcessor((BeanPostProcessor) o);
        }
    }

    @Override
    public void refersh() throws Exception {
        ResourceLoader resourceLoader = new ResourceLoader();
        AbstractBeanDefinitionReader reader = new XmlBeanDefinitionReader(resourceLoader);
        reader.loadBeanDefination(configLocation);
        for (Map.Entry<String, BeanDefinition> definitionEntry : reader.getRegistry().entrySet()) {
            beanFactroy.registerBeanDefinition(definitionEntry.getKey(), definitionEntry.getValue());
        }
        String packageName = reader.getPackageName();
        if (packageName == null) {
            return;
        }
        AnnotationParser parser = new AnnotationParser();
        parser.AnnotationParserReader(packageName);
        for (Map.Entry<String, BeanDefinition> definitionEntry : parser.getMap().entrySet()) {
            beanFactroy.registerBeanDefinition(definitionEntry.getKey(), definitionEntry.getValue());
        }

    }
}
