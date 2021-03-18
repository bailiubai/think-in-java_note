package com.bai.pojo;

import com.bai.chap11.Pet;

/**
 * @Author:liubai
 * @Time : 2021/3/18 15:07
 */
public class Cat extends Pet {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
    }
}
