package com.bai.chap11;

import java.util.*;

/**
 * createTime:2021/2/19 17:30
 * author:留白
 * desc:
 */
public class AddingGroups {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer[] moreIntes = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreIntes));
        Collections.addAll(collection,11,12,13,14,15);
        Collections.addAll(collection,moreIntes);
        List<Integer> list = Arrays.asList(16,17,18,19,20);
        list.set(1,99);
        list.add(1);
        list.remove(0);


    }

}
