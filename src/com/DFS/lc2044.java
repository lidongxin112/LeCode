package com.DFS;

import java.util.HashMap;
import java.util.Map;

/**
 *给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的
 * 不同非空子集的数目 。
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。
 * 如果选中的元素下标位置不一样，则认为两个子集 不同 。
 * 对数组 a 执行 按位或，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 * @author 东鑫
 */
public class lc2044 {
    static Map<Integer, Integer> map = new HashMap<>();
    static {
        for (int i = 0; i < 20; i++) {
            map.put((1 << i), i);
        }
    }
    int[] nums;
    int max = 0, ans = 0;

        public int countMaxOrSubsets(int[] nums) {
            int maxOr = 0, cnt = 0;
            for (int i = 0; i < 1 << nums.length; i++) {
                int orVal = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (((i >> j) & 1) == 1) {
                        orVal |= nums[j];
                    }
                }
                if (orVal > maxOr) {
                    maxOr = orVal;
                    cnt = 1;
                } else if (orVal == maxOr) {
                    cnt++;
                }
            }
            return cnt;

            //
//        int n1 = 0;
//        for (int i:nums){
//            n1 = n1 | i;
//        }
//
//        System.out.println(n1);
//       return 1;
    }

    public int countMaxOrSubsets1(int[] nums) {
        int n = nums.length, mask = 1 << n;
        int[] f = new int[mask];
        int max = 0, ans = 0;
        for (int s = 1; s < mask; s++) {
            int lowbit = (s & -s);
            int prev = s - lowbit, idx = map.get(lowbit);
            f[s] = f[prev] | nums[idx];
            if (f[s] > max) {
                max = f[s]; ans = 1;
            } else if (f[s] == max) {
                ans++;
            }
        }
        return ans;
    }
    public int countMaxOrSubsets2(int[] _nums) {
        nums = _nums;
        dfs(0, 0);
        return ans;
    }
    void dfs(int u, int val) {
        if (u == nums.length) {
            if (val > max) {
                max = val; ans = 1;
            } else if (val == max) {
                ans++;
            }
            return ;
        }
        dfs(u + 1, val);
        dfs(u + 1, val | nums[u]);
    }


    public static void main(String[] args) {
        System.out.println(2 | 2 );
        int [] nums = {3,2,5,1};
        int i = new lc2044().countMaxOrSubsets(nums);
        System.out.println(i);
    }
}
