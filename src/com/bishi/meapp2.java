package com.bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class meapp2 {
    public static int[] answer(int x) {
        List<Integer> an = an(x);
        int i = an1(an, 5);
        return an2(i);
    }

    public static List<Integer> an(int x) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        int n = 1;
        list.add(1);
        for (int i = 2; i <= x; i++) {
            if (x % i == 0) {
                list.add(i);
                n = n + 1;
            }
        }
        int nb = list.size();
        if (list.size() > 5) {
            for (int i = 0; i < 5; i++) {
                list1.add(list.get(nb - i - 1));
            }
            return list1;
        } else {
            return list;
        }
    }

    public static int an1(List<Integer> list, int fee) {
        if (list.size() < 2) {
            return 0;
        }
        int n = 0;
        int[][] dp = new int[list.size() + 1][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -list.get(i) - fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + list.get(i));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - list.get(i) - fee);
        }
        return dp[list.size()][0];
    }

    public static int[] an2(int x) {
        List<Integer> list = new ArrayList<>();
        while (x  > 0) {
            int a = x % 7;
            list.add(a);
            x = x / 7;
        }
        int[] aa = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            aa[i] = list.get(i);
        }
        Arrays.sort(aa);
        return aa;
    }

    public static void main(String[] args) {
        an2(69);
    }
}
