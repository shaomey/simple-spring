package com.smy.xml;

import com.smy.AbstractBeanDefinationReader;
import com.smy.BeanDefinition;
import com.smy.BeanReference;
import com.smy.PropertyValue;
import com.smy.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * 解析xml类 讲过这里解析后Registry中的beanDefinition bean为空
 * Created by shaomy on 2019/10/23/023.
 */
public class XmlBeanDefinationReader extends AbstractBeanDefinationReader {
    public XmlBeanDefinationReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefination(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinations(inputStream);
    }

    /**
     * DocumentBuilderFactory 能使从xml文档中生成dom对象树的解析器
     * Document 表示整个xml或html文档
     *
     * @param inputStream
     * @throws Exception
     */
    protected void doLoadBeanDefinations(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        registerBeanDefinations(doc);
    }

    protected void registerBeanDefinations(Document document) {
        Element element = document.getDocumentElement();
        parseBeanDefination(element);
    }

    /**
     * NodeList提供了结点有序结合的抽象 可以通过整数索引访问
     * Node是xml,html文档中结点(元素)的表示
     * Element表示一个xml文档或html文档的元素
     * <p>
     * 目前root指的是beans 后面还指(component-scan);element指的是bean
     *
     * @param root
     */
    protected void parseBeanDefination(Element root) {
        NodeList list = root.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                processBeanDefinition(element);
            }
        }
    }

    /**
     * 这个方法就是从一个bean中获取name和class
     * 并将name和class值放到beanDefinition中
     * @param ele
     */
    protected void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(ele, beanDefinition);
        beanDefinition.setBeanClsName(className);
        getRegistry().put(name, beanDefinition);
    }

    /**
     * 显然这个类适用于处理"属性"
     * 如果一个属性是基本类型(目前只能处理String) 直接在beanDefinition中添加属性
     * 如果是一个引用类型 则将这个引用类型放入beanReference中 方便对引用类型进实例化
     *
     * @param element
     * @param beanDefinition
     */
    private void processProperty(Element element, BeanDefinition beanDefinition) {
        NodeList list = element.getElementsByTagName("property");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node instanceof Element) {
                Element propertyElement = (Element) node;
                String name = propertyElement.getAttribute("name");
                String value = propertyElement.getAttribute("value");
                if (value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                } else {
                    String ref = propertyElement.getAttribute("ref");
                    if (ref != null && ref.length() > 0) {
                        BeanReference beanReference = new BeanReference(ref);
                        beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                    } else {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }
                }
            }
        }
    }
}
