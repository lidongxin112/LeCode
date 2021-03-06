package com.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。
 * 返回妹妹可以获得的最大糖果的种类数。
 */
public class lc575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i:candyType){
            set.add(i);
        }
        return Math.min(set.size(),candyType.length/2);
    }

    public static void main(String[] args) {
        int [] cad = {1,1,2,3};
        int i = new lc575().distributeCandies(cad);
        System.out.println(i);
    }
}
