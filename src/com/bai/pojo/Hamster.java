package com.bai.pojo;

import com.bai.chap11.Pet;

/**
 * @Author:liubai
 * @Time : 2021/3/18 15:11
 */
public class Hamster extends Pet {

    private String name;

    public Hamster(String name) {
        this.name = name;
    }

    public Hamster() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
