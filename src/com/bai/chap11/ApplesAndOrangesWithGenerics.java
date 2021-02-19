package com.bai.chap11;

import java.util.ArrayList;

/**
 * createTime:2021/2/19 16:11
 * author:留白
 * desc:
 */
public class ApplesAndOrangesWithGenerics {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i=0 ; i<3 ; i++)
            apples.add(new Apple());
            //apples.add(new Orange());
        for (int i=0 ; i<apples.size() ; i++)
            System.out.println(apples.get(i).id());
        for (Apple apple : apples)
            System.out.println(apple.id());

    }

}
