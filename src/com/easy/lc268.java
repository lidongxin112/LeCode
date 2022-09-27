package com.easy;

import java.util.Arrays;

/**
 * 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class lc268 {
    public int missingNumber(int[] nums) {
        int x = 0;
        for (int i=0;i<nums.length;i++){
            x^= nums[i];
        }
        for (int i=0;i<=nums.length;i++){
            x^= i;
        }
        return x;
    }
}
