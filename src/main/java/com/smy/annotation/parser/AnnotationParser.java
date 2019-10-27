package com.smy.annotation.parser;

import com.smy.BeanDefinition;
import com.smy.annotation.Controller;
import com.smy.annotation.Service;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * annotataionParser
 * Created by shaomy on 2019/10/26/026.
 */
public class AnnotationParser {
    private Map<String, BeanDefinition> map = new HashMap<>();

    public Map<String, BeanDefinition> getMap() {
        return map;
    }

    /**
     * @param packageName etc (com.smy)
     * @throws ClassNotFoundException
     */
    public void AnnotationParserReader(String packageName) throws ClassNotFoundException {
        Set<String> classNames = getClassName(packageName);
        Class[] types = {Controller.class, Service.class};
        for (String className : classNames) {
            Annotation annotation = null;
            int i;
            for (i = 0; i < types.length; i++) {
                annotation = Class.forName(className).getAnnotation(types[i]);
                if (annotation != null) {
                    break;
                }
            }
            if (annotation != null) {
                String beanName = null;
                switch (i) {
                    case 0:
                        beanName = ((Controller) annotation).value();
                        break;
                    case 1:
                        beanName = ((Service) annotation).value();
                        break;
                }
                if (beanName == null || beanName.length() == 0) {
                    String[] elements = className.split("\\.");
                    String SimpleName = elements[elements.length - 1];
                    beanName = SimpleName.substring(0, 1).toLowerCase() + SimpleName.substring(1);
                    BeanDefinition beanDefinition = new BeanDefinition();
                    beanDefinition.setBeanClsName(className);
                    map.put(beanName, beanDefinition);
                }
            }
        }

    }

    /**
     * 获取此packageName下所有文件
     * 对packageName做判断
     *
     * @param packageName
     * @return
     */
    public Set<String> getClassName(String packageName) {
        Set<String> classNames = null;
        ClassLoader classLoader = getClass().getClassLoader();
        String packagePath = packageName.replace(".", "/");
        URL url = classLoader.getResource(packagePath);
        assert url != null;
        String protocol = url.getProtocol();
        if (protocol.equals("file")) {
            classNames = getClassNameFromDir(url.getPath(), packageName);
        }
        return classNames;
    }

    /**
     * 获取代包名的类名 etc(com.smy.aop.CglibTest)
     *
     * @param path
     * @param packageName
     * @return
     */
    private Set<String> getClassNameFromDir(String path, String packageName) {
        Set<String> classNames = new HashSet<>();
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                classNames.addAll(getClassNameFromDir(file.getPath(), packageName + "." + file.getName()));
            } else {
                String fileName = file.getName();
                if (fileName.endsWith(".class") && !fileName.contains("$")) {
                    classNames.add(packageName + "." + fileName.replace(".class", ""));
                }
            }
        }
        return classNames;
    }
}
