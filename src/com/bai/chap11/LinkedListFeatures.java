package com.bai.chap11;

import com.bai.utils.Pets;

import java.util.LinkedList;
import static com.bai.utils.Print.*;

/**
 * createTime:2021/2/22 16:01
 * author:留白
 * desc:
 */
public class LinkedListFeatures {

    public static void main(String[] args) {
        LinkedList<Pet> pets =new LinkedList<>(Pets.arrayList(5));
        println(pets);
        println("pets.getFirst():"+pets.getFirst());
        println("pets.element():"+pets.element());
        println("pets.peek():"+pets.peek());
        println("pets.remove():"+pets.remove());
        println("pets.removeFirst():"+pets.removeFirst());
        println("pets.poll():"+pets.poll());
        println(pets);
        pets.addFirst(new Pet());
        println("After addFirst()"+pets.getFirst());
        pets.add(Pets.randomPet());
        println("After offer()"+pets.getFirst());

    }

}
