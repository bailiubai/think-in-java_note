package com.bai.chap11;

import java.util.Map;

/**
 * @Author:liuBai
 * @Time : 2021/6/18 16:19
 */
public class EnvironmentVariables {

    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }

}
