package com.bai.chap11;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * createTime:2021/2/22 16:50
 * author:留白
 * desc:
 */
public class SortedSetOfInteger {

    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> intset = new TreeSet<Integer>();
        for (int i=0;i<10000;i++)
            intset.add(rand.nextInt(30));
        System.out.println(intset);
    }

}
