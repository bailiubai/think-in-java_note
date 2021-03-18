package com.bai.chap11;

import com.bai.pojo.Cat;
import com.bai.pojo.Dog;
import com.bai.pojo.Hamster;
import com.bai.utils.Print;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:liubai
 * @Time : 2021/3/18 15:05
 */
public class PetMap {

    public static void main(String[] args) {
        Map<String,Pet> petMap = new HashMap<String,Pet>();
        petMap.put("My Cat",new Cat("Molly"));
        petMap.put("My Dog",new Dog("Ginger"));
        petMap.put("My Hamster",new Hamster("Bosco"));
        Print.println(petMap);
        Pet dog = petMap.get("My Dog");
        Print.println(dog);
        Print.println(petMap.containsKey("My Dog"));
        Print.println(petMap.containsValue(dog));
    }

}
