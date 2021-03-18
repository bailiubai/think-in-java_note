package com.bai.chap11;

import com.bai.pojo.*;
import com.bai.utils.Print;

import java.util.*;

/**
 * @Author:liubai
 * @Time : 2021/3/18 15:19
 */
public class MapOfList {

    public static Map<Person, List<? extends  Pet>> petPeople = new HashMap<Person,List<? extends Pet>>();

    static {
        petPeople.put(new Person("Dawn",18), Arrays.asList(new Cymric("Molly"),new Mutt("Spot")));
        petPeople.put(new Person("Kate",20),Arrays.asList(new Cat("Shackleton"),new Cat("Elsie May"),new Dog("Margrett")));
    }

    public static void main(String[] args) {
        Print.println("People:"+petPeople.keySet());
        Print.println("Pets:"+petPeople.values());
        for (Person person : petPeople.keySet()){
            Print.print(person+" has:");
            for (Pet pet : petPeople.get(person)){
                Print.println(pet);
            }
        }

    }
}
