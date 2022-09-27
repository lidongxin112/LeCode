package com.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 最好时间复杂度o(nlog2(n)) 空间复杂度 o(log2n)
 * @author 东鑫
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10,6,3,8,33,27,66,9,7,88};
//        int[] arr = new int[]{1,3,2};
        f(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void f(int[] arr,int start,int end){
        //直到start>=end时结束递归
        if(start<end){
            int left = start;
            int right = end;
            int temp = arr[start];
            while(left<right){
                //右面的数字大于标准数时，右边的数的位置不变，指针向左移一个位置
                while(left<right && arr[right]>temp){
                    right--;
                }
                //右边的数字及下标小于或等于基本数，将右边的数放到左边
                if(left<right) {
                    arr[left] = arr[right];
                    left++;
                }
                ////左边的数字小于或等于标准数时，左边的数的位置不变，指针向右移一个位置
                while(left<right && arr[left]<=temp){
                    left++;
                }
                //左边的数字大于基本数，将左边的数放到右边
                arr[right] = arr[left];
            }
            //一趟循环结束，此时left=right，将基数放到这个重合的位置，
            arr[left] = temp;

            //将数组从left位置分为两半，继续递归下去进行排序
            f(arr,start,left);
            f(arr,left+1,end);
        }
    }
}
