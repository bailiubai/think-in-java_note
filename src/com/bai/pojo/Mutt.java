package com.bai.pojo;

import com.bai.chap11.Pet;

/**
 * @Author:liubai
 * @Time : 2021/3/18 15:26
 */
public class Mutt extends Pet {

    private String name;

    public Mutt(String name) {
        this.name = name;
    }

    public Mutt() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
