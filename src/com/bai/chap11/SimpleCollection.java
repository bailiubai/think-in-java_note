package com.bai.chap11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * createTime:2021/2/19 16:50
 * author:留白
 * desc:
 */
public class SimpleCollection {

    public static void main(String[] args) {
        Collection<Integer> integers = new HashSet<>();
        for (int i=0;i<10;i++)
            integers.add(i);
        for (Integer i : integers)
            System.out.print(i+",");
    }

}
