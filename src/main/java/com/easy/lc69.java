package com.easy;

/**
 * 剑指 Offer II 069. 山峰数组的顶部
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 * 输入：arr = [1,3,5,4,2]
 * 输出：2
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 */
public class lc69 {
    public int peakIndexInMountainArray(int[] arr) {
        int a = arr.length;
        int i = 0;
        int j = 1;
        while (arr[i] <= arr[j]) {
            if (arr[i] <= arr[j]) {
                i++;
                j++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        int i = new lc69().peakIndexInMountainArray(arr);
        System.out.println(i);
    }
}
