package com.SlidingWindow;

/**
 * @author 东鑫
 * 滑动窗口
 */
public class huadong {
    //单个子数组的最大和
    public int[] maxSumOfOneSubarray(int[] nums, int k) {
        int[] ans = new int[1];
        int sum1 = 0, maxSum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            if (i >= k - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    ans[0] = i - k + 1;
                }
                sum1 -= nums[i - k + 1];
            }
        }
        System.out.println(sum1);
        return ans;
    }

    //两个无重叠子数组的最大和
    public int[] maxSum(int[] nums, int k) {
        int[] ans = new int[2];
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum2 = 0;
        for (int i = k; i < nums.length; i++) {
            sum1 += nums[i - k];
            sum2 += nums[k];
            if (i >= k * 2 - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Idx = i - k * 2 + 1;
                }
            }

            if (maxSum1 + sum2 > maxSum2) {
                maxSum2 = maxSum1 + sum2;
                ans[0] = maxSum1Idx;
                ans[1] = i - k + 1;
            }
            sum1 -= nums[i - 2 * k + 1];
            sum2 -= nums[i - k + 1];
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int[] ints = new huadong().maxSumOfOneSubarray(nums, 2);
        for (int a : ints) {
            System.out.println(a);
        }
    }
}
