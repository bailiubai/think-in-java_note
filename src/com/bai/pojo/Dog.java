package com.bai.pojo;

import com.bai.chap11.Pet;

/**
 * @Author:liubai
 * @Time : 2021/3/18 15:10
 */
public class Dog extends Pet {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog() {
    }
}
