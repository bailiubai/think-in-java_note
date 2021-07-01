package com.bai.chap11;

/**
 * createTime:2021/2/22 14:51
 * author:留白
 * desc:
 */
public class Pet implements Comparable{

    public static int num;
    public int id = num++;
    public String name=id+"+"+id;

    public int id() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        Pet p = (Pet)o;
        if (p.id()<this.id()){
            return p.id;
        }
        return this.id();
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
