package com.bai.chap12;

/**
 * @Author:liuBai
 * @Time : 2021/6/21 11:11
 */
class SimpleException extends Exception {



}


public class InheritingException{

    public void f() throws SimpleException{
        System.err.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingException sed = new InheritingException();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }

}