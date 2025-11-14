package com.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2104. 子数组范围和
 * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 * <p>
 * 返回 nums 中 所有 子数组范围的 和 。
 * <p>
 * 子数组是数组中一个连续 非空 的元素序列。
 *
 * @author 东鑫
 */
public class lc2104 {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, nums[j]);

                min = Math.min(min, nums[j]);

                res += (max - min);
            }
        }
        return res;
    }

    int n;

    public long subArrayRanges1(int[] nums) {
        n = nums.length;
        // min[i] 为 nums[i] 作为区间最小值的次数；max[i] 为 nums[i] 作为区间最大值的次数
        long[] min = getCnt(nums, true), max = getCnt(nums, false);
        long ans = 0;
        for (int i = 0; i < n; i++) ans += (max[i] - min[i]) * nums[i];
        return ans;
    }

    long[] getCnt(int[] nums, boolean isMin) {
        int[] a = new int[n], b = new int[n];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && (isMin ? nums[d.peekLast()] >= nums[i] : nums[d.peekLast()] <= nums[i]))
                d.pollLast();
            a[i] = d.isEmpty() ? -1 : d.peekLast();
            d.addLast(i);
        }
        d.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!d.isEmpty() && (isMin ? nums[d.peekLast()] > nums[i] : nums[d.peekLast()] < nums[i])) d.pollLast();
            b[i] = d.isEmpty() ? n : d.peekLast();
            d.addLast(i);
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) ans[i] = (i - a[i]) * 1L * (b[i] - i);
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        long l = new lc2104().subArrayRanges(nums);
        System.out.println(l);
    }
}
