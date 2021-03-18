package com.bai.pojo;

import com.bai.chap11.Pet;

/**
 * @Author:liubai
 * @Time : 2021/3/18 15:25
 */
public class Cymric extends Pet {

    private String name;

    public Cymric(String name) {
        this.name = name;
    }

    public Cymric() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
