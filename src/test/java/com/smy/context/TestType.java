package com.smy.context;

import com.smy.School;

import java.lang.reflect.Field;

/**
 * Created by shaomy on 2019/10/23/023.
 */
public class TestType {
    public static void main(String[] args) throws NoSuchFieldException {
        School school = new School();
        Field field = school.getClass().getDeclaredField("a");
        System.out.println(field.getType().toString());
        System.out.println();
    }
}
