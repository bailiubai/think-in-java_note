package com.bai.chap11;

import java.util.Stack;

/**
 * createTime:2021/2/22 16:30
 * author:留白
 * desc:
 */
public class StackCollision {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String s:"My dog has fleas".split(" "))
            stack.push(s);
        while (!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();

    }

}
