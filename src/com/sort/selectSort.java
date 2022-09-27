package com.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 选择排序
 * 时间复杂度o(n2) 空间复杂度o(1)
 *
 * @author 东鑫
 */
public class selectSort {
    public static void main(String[] args) {
        int[] n = new int[]{1, 6, 3, 8, 33, 27, 66, 9, 7, 88};
        int temp, index = -1;
        for (int i = 0; i < n.length - 1; i++) {
            index = i;
            //如果大于，暂存较小的数的下标
            for (int j = i + 1; j < n.length; j++) {
                if (n[index] > n[j]) {
                    index = j;
                }
            }
            ////将一趟下来求出的最小数，与这个数交换
            if (index > 0) {
                temp = n[i];
                n[i] = n[index];
                n[index] = temp;
            }
            System.out.println(Arrays.toString(n));
        }
        System.out.println(Arrays.toString(n));
    }
}
