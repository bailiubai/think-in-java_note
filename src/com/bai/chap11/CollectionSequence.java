package com.bai.chap11;

import com.bai.utils.Pets;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * @Author:liuBai
 * @Time : 2021/6/17 10:11
 */
public class CollectionSequence extends AbstractCollection<Pet> {

    private Pet[] pets = Pets.createArray(8);



    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {

            private int index = 0;

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

    @Override
    public int size() {
        return pets.length;
    }


    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        c.iterator().remove();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}
