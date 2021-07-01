package com.bai.gc;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:liuBai
 * @Time : 2021/5/13 17:37
 */
public class TestThreadLocalLeak {

    /*public static void main(String[] args) {
        //String str = new String("Test ThreadLocal memory leak!");
        WeakReference<String> weakReference = new WeakReference<String>(new String("Test ThreadLocal memory leak!"));

        System.gc();
        if (weakReference.get() == null ){
            System.out.println("weak已经被GC回收");
        }else{
            System.out.println(weakReference.get());
        }
    }*/

    public static void main(String[] args) {
        //  为了复现key被回收的场景，我们使用临时变量
        ThreadLocalMemory memeory = new ThreadLocalMemory();
    }

    static class ThreadLocalMemory{
        public ThreadLocal<List<Object>> threadId = new ThreadLocal<List<Object>>(){
            @Override
            protected List<Object> initialValue(){
                List<Object> list = new ArrayList<Object>();
                for (int i = 0; i < 10000; i++) {
                    list.add(String.valueOf(i));
                }
                return list;
            }
        };

        public List<Object> get(){
            return threadId.get();
        }

        public void remove(){
            threadId.remove();
        }
    }

}
