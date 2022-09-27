package com.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 453. 最小操作次数使数组元素相等
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：0
 */
public class lc453 {
        public int minMoves(int[] nums) {
            int minNum = Arrays.stream(nums).min().getAsInt();
            int res = 0;
            for (int num : nums) {
                res += num - minNum;
            }
            return res;
        }
    public static void main(String[] args) {
        int [] a = {1,2,3};
        int i = new lc453().minMoves(a);
        System.out.println(i);
    }
}
