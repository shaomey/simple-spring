package com.smy.context;

import com.smy.School;
import org.junit.Test;

/**
 * test
 * Created by shaomy on 2019/10/23/023.
 */
public class ApplicationContextTest {
    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClasspathXmlApplicationContext("test.xml");
        School school = (School) context.getBean("school");
        school.print();
//        Field field = school.getClass().getDeclaredField("age");
//        System.out.println(field.getType());
    }
}
/**
 *
 * Integer
 * Long
 * Short
 * Character
 * Boolean
 * Byte
 * Float
 * Double
 */