package com.weiyunsuan;

import java.util.Arrays;

/**
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class lc137 {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 32; ++i) {
                int total = 0;
                for (int num: nums) {
                    total += ((num >> i) & 1);
                }
                if (total % 3 != 0) {
                    ans |= (1 << i);
                }
            }
            return ans;
        }

    public static void main(String[] args) {

        System.out.println(1&3^2^2^2);
        int nums[] = {2,3,2};
        int i = new lc137().singleNumber(nums);
        System.out.println(i);
    }
}
