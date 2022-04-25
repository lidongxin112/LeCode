package com.sort;

import java.util.Arrays;

/**
 * 冒泡排序 时间复杂度o(n2) 空间复杂度 o(1)
 * @author 东鑫
 */
public class BubbleSorting {
    public static void main(String[] args) {
        int[] n = new int[]{1,6,3,8,33,27,66,9,7,88};
        int temp;
        for (int i = 0; i < n.length-1; i++) {
            for (int j = 0; j <n.length-1; j++) {
                if(n[j]>n[j+1]){
                    temp = n[j];
                    n[j] = n[j+1];
                    n[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(n));
    }
}
