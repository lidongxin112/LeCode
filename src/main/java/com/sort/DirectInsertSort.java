package com.sort;

import java.util.Arrays;

/**
 * 时间复杂度最好o(n) 最坏o(n2)
 * 平均复杂度o(n2)
 * 空间复杂度o(1)
 * @author 东鑫
 */
public class DirectInsertSort {
    public static void main(String[] args) {
        int[] n = new int[]{20,12,15,1,5,49,58,24,578,211,20,214,78,35,125,789,11};
        int temp = 0,j;
        for (int i = 1; i < n.length; i++) {
            temp = n[i];
            for (j = i; j >0; j--) {
                //如果当前数前面的数大于当前数，则把前面的数向后移一个位置
                if(n[j-1]>temp){
                    n[j] = n[j-1];
                    //第一个数已经移到第二个数，将当前数放到第一个位置，这一趟结束
                    if(j==1){
                        n[j-1] = temp;
                        break;
                    }

                }else{//如果不大于，将当前数放到j的位置，这一趟结束

                    n[j] = temp;
                    break;
                }
            }
            System.out.println(Arrays.toString(n));
        }
        System.out.println(Arrays.toString(n));
    }
}
