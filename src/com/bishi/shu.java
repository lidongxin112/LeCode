package com.bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class shu {
    public int[][] twoPlus(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == 10) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                }
            }
        }
        int m = list.size();
        int[][] num = new int[m / 2][2];
        for (int i = 0; i < m; ) {
            if (list.get(i) < list.get(i + 1)) {
                num[i / 2][0] = list.get(i);
                num[i / 2][1] = list.get(i + 1);
            } else {
                continue;
            }
            i += 2;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] aa = {-2, 28, -2, 19, -9, 21, 15, 20, -10, -18};
        int[][] ints = new shu().twoPlus(aa);
        int n = ints.length;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
    }
}
