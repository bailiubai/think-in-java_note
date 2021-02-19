package com.bai.chap11;

import java.util.ArrayList;

/**
 * createTime:2021/2/19 16:33
 * author:留白
 * desc:
 */
public class Gerbil {

    private static long num;
    private final long gerbilNumber = num++;
    public void hop(){
        System.out.println("Gerbil["+gerbilNumber+"]"+"正在跳跃！");
    }


    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        for (int i=0;i<5;i++)
            gerbils.add(new Gerbil());
        for (Gerbil gerbil:gerbils)
            gerbil.hop();
    }

}
