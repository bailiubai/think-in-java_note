package com.bai.chap12;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author:liuBai
 * @Time : 2021/6/21 11:24
 */
class MyException extends Exception {

    public MyException(){}
    public MyException(String msg){super(msg);}

}

public class FullConstructors{

    public static final Logger LOGGER = LoggerFactory.getLogger(FullConstructors.class);

    public static void f() throws MyException{
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException{
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
            LOGGER.error("错误信息:",e);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }

}
