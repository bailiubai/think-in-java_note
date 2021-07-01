package com.bai.chap11;

import com.bai.utils.Pets;

import java.util.Iterator;

class PetSequence{
    protected Pet[] pets = Pets.createArray(8);
}
/**
 * @Author:liuBai
 * @Time : 2021/6/17 10:28
 */
public class NonCollectionSequence extends PetSequence{

    public Iterator<Pet> iterator(){
        return new Iterator<Pet>() {

            private int index;

            @Override
            public boolean hasNext() {
                return index<pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }

}
