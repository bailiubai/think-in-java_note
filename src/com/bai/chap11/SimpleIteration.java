package com.bai.chap11;

import com.bai.utils.Pets;

import java.util.Iterator;
import java.util.List;

/**
 * createTime:2021/2/22 14:49
 * author:留白
 * desc:
 */
public class SimpleIteration {

    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()){
            Pet p = it.next();
            System.out.println(p.id()+":"+p.name+" ");
        }
        System.out.println();
        for (Pet p:pets)
            System.out.println(p.id()+":"+p.name+" ");
        System.out.println();
        it = pets.iterator();
        for (int i=0;i<6;i++){
//            it.next();
            it.remove();
        }
        System.out.println(pets);
    }

}
