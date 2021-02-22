package com.bai.chap11;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * createTime:2021/2/22 16:46
 * author:留白
 * desc:
 */
public class SetOfInteger {

    public static void main(String[] args) {
        Random random = new Random(47);
        Set<Integer> intset = new HashSet<Integer>();
        for (int i=0;i<10000;i++)
            intset.add(random.nextInt(30));
        System.out.println(intset);
    }

}
