package com.smy.context;

/**
 * Created by shaomy on 2019/10/23/023.
 */
public class TestType implements TestInterface{
    public void say(){
        System.out.println(this.getClass().getClassLoader());
    }
    public static void main(String[] args) throws NoSuchFieldException {
//        School school = new School();
//        Field field = school.getClass().getDeclaredField("a");
//        System.out.println(field.getType().toString());
//        System.out.println();
        TestType testType = new TestType();
        testType.say();
    }
}
