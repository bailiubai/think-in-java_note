package com.bai.chap11;

import com.bai.utils.Pets;

import java.util.List;
import java.util.ListIterator;

/**
 * createTime:2021/2/22 15:41
 * author:留白
 * desc:
 */
public class ListIteration {

    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()){
            System.out.print(it.next().name+"，"+it.nextIndex()+"，"+it.previousIndex()+";");
        }
        System.out.println();
        while (it.hasPrevious()){
            System.out.print(it.previous().id()+" ");
        }
        System.out.println();
        System.out.println(pets);
        it = pets.listIterator(3);
        while (it.hasNext()){
            it.next();
            it.set(Pets.randomPet());
        }
        System.out.println(pets);
    }

}
