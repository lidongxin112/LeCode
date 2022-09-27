package com.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 */
public class lc1218 {
    public int longestSubsequence(int[] arr, int difference) {
//        int ans = 0;
//    Map<Integer,Integer> map = new HashMap<>();
//    for (int v:arr){
//        map.put(v,map.getOrDefault(v-difference,0)+1);
//        ans = Math.max(ans,map.get(v));
//    }
//    return ans;

        int ans = 0;
        int [] dp = new int[40001];
        for (int num:arr){
            dp[num+20000] = dp[num + 20000 - difference]  + 1;
            ans = Math.max(ans,dp[num+20000]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {1,5,7,8,5,3,4,2,1};

        int i = new lc1218().longestSubsequence(arr, -2);
        System.out.println(i);
    }
}
