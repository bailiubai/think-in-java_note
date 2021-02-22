package com.bai.chap11;

import java.util.*;

import static com.bai.utils.Print.*;

/**
 * createTime:2021/2/22 9:33
 * author:留白
 * desc:
 */
public class PrintingContainers {

    static Collection fill(Collection<String> collection){
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String,String> map){
        map.put("rat","Fuzzy");
        map.put("cat","Rags");
        map.put("dog","Bosco");
        map.put("dog","Spot");
        return map;
    }

    public static void main(String[] args) {
        println(fill(new ArrayList<String>()));//可以存放重复元素
        println(fill(new LinkedList<String>()));//可以存放重复元素
        println(fill(new HashSet<String>()));//不可以存放重复元素（自动去重）
        println(fill(new TreeSet<String>()));//不可以存放重复元素（自动去重）
        println(fill(new LinkedHashSet<String>()));//不可以存放重复元素（自动去重）
        println(fill(new HashMap<String,String>()));//键值不可重复，最快的保存速度
        println(fill(new TreeMap<String,String>()));//键值不可重复，自动排序（按照比较结果的升序保存对象）
        println(fill(new LinkedHashMap<String,String>()));//键值不可重复（技能快速保存元素，也可以将元素排序）
    }

}
