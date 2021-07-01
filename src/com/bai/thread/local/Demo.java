package com.bai.thread.local;

/**
 * @Author:liuBai
 * @Time : 2021/5/13 17:08
 */
public class Demo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            ThreadLocal<String> local = new ThreadLocal<>();
            ThreadLocal<String> local2 = new ThreadLocal<>();
            local.set("张三");
            local2.set("李四");
            String s = local.get();
            String s1 = local2.get();
            System.out.println(s+":"+s1);
        });
        Thread thread2 = new Thread(() -> {
            ThreadLocal<String> local = new ThreadLocal<>();
            ThreadLocal<String> local2 = new ThreadLocal<>();
            local.set("张三1");
            local2.set("李四1");
            String s = local.get();
            String s1 = local2.get();
            System.out.println(s+":"+s1);
        });
        thread1.start();
        thread2.start();
    }

}
