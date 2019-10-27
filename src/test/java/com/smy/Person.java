package com.smy;

import com.smy.annotation.Autowired;

/**
 * test
 * Created by shaomy on 2019/10/23/023.
 */
public class Person {
    private int height;
    private String word;
    @Autowired
    private School school;

    public void sayHeight() {
        System.out.println(height);
    }
    public void sayHello(){
        System.out.println("Hello");
    }

    public void say() {
        System.out.println(word);
    }

    public void age() {
        System.out.println(school.getAge());
    }
}
