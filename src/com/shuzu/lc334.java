package com.shuzu;

/**
 * @author 东鑫
 * 334. 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k]
 * 返回 true ；否则，返回 false 。
 */
public class lc334 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
            if (maxans == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet1(int[] nums) {
        int a = nums[0], b = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= a) {
                a = nums[i];
            }else if (nums[i]<=b){
                b = nums[i];
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        boolean b = new lc334().increasingTriplet(nums);
        System.out.println(b);
    }
}
