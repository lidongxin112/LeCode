package com.shuzu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 506. 相对名次
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 *
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 *
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 */
public class lc506 {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int [] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = score[i];
        }
        Arrays.sort(nums);
        String [] as = new String[n];

        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<n;i++){
            map.put(nums[i],n-i);
        }
        for (int i=0;i<n;i++) {
            int mc = map.get(score[i]);
            if (mc == 1) {
                as[i] = "Gold Medal";
            }else if (mc==2){
                as[i] = "Silver Medal";
            }else if (mc==3){
                as[i]  = "Bronze Medal";
            }else {
                as[i] =mc + "";
            }
        }
        return as;
    }

    public static void main(String[] args) {
        int [] score = {5,4,3,2,1};
        String[] relativeRanks = new lc506().findRelativeRanks(score);
        for (String s:relativeRanks){
            System.out.print(s);
        }
    }
}
