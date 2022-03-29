package com.shuzu;


import java.util.HashSet;

/**
 * @author 东鑫
 */
public class lc219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        if (set.size() == n) {
            return false;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == nums[i] && Math.abs(j - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        boolean b = new lc219().containsNearbyDuplicate(nums, 3);
        System.out.println(b);
    }
}

