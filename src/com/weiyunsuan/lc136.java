package com.weiyunsuan;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class lc136 {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i=0;i<nums.length;i++){
             a = nums[i] ^ a;
        }
        return a;
    }

    public static void main(String[] args) {
        int [] nums = {2,2,1};
        int i = new lc136().singleNumber(nums);
        System.out.println(i);
        System.out.println(2^2^1);
    }
}
