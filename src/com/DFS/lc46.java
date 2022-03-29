package com.DFS;

import java.util.*;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class lc46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        bac(res);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        if (first == n) {
            set.add(output);
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public void bac(List<List<Integer>> res) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (List<Integer> a : res) {
            set.add(a);
        }
        res.clear();
        for (List<Integer> a : set) {
            res.add(a);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> permute = new lc46().permute(nums);
//        Set<List<Integer>> set = new HashSet<List<Integer>>();
//        for (List<Integer> a:permute){
//            set.add(a);
//        }

        for (List<Integer> a : permute) {
            System.out.println(a);
        }
    }

}
