package com.bai.chap11;

import com.bai.utils.Pets;

import java.util.*;

/**
 * createTime:2021/2/22 15:07
 * author:留白
 * desc:
 */
public class CrossContainerIteration {

    public static void display(Iterator<Pet> it){
        while (it.hasNext()){
            Pet p = it.next();
            System.out.print(p.id()+":"+p.name+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Pet> pets = (ArrayList<Pet>) Pets.arrayList(8);
        LinkedList<Pet> petsLL = new LinkedList<>(pets);
        HashSet<Pet> petsHS = new HashSet<>(pets);
        TreeSet<Pet> petsTS = new TreeSet<>(pets);
        display(pets.iterator());
        display(petsLL.iterator());
        display(petsHS.iterator());
        display(petsTS.iterator());
    }

}
