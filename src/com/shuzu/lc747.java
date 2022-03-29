package com.shuzu;

/**
 * @author 东鑫
 * 747. 至少是其他数字两倍的最大数
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。
 * 如果是，则返回 最大元素的下标 ，否则返回 -1 。
 */
public class lc747 {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                n = i;
            }
            if (n != i) {
                if (nums[i] > max || nums[i] * 2 > max) {
                    return -1;
                }
            }
        }
        return n;
}

    public static void main(String[] args) {
        int[] n = {1};
        int i = new lc747().dominantIndex(n);
        System.out.println(i);
    }
}
