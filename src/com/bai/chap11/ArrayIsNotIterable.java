package com.bai.chap11;

import java.util.Arrays;

/**
 * @Author:liuBai
 * @Time : 2021/6/18 16:28
 */
public class ArrayIsNotIterable {

    static <T> void test(Iterable<T> ib){
        for (T t:ib)
            System.out.print(t + " ");
    }

    public static void main(String[] args) {
        test(Arrays.asList(1,2,3));
        String[] strings = {"A","B","C"};
        test(Arrays.asList(strings));
    }

}
