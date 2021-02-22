package com.bai.utils;

import com.bai.chap11.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * createTime:2021/2/22 14:52
 * author:留白
 * desc:
 */
public class Pets{

    public static List<Pet> arrayList(int i){
        List<Pet> pets = new ArrayList<>();
        for (int a=0;a<i;a++){
            pets.add(new Pet());
        }
        return pets;
    }

    public static Pet randomPet(){
        return new Pet();
    }

}
