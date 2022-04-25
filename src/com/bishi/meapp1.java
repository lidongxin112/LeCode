package com.bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class meapp1 {
    public static int[] answer(int x) {
        List<Integer> an = an(x);
        int i = an1(an, 1);
        return an3(i);
    }

    public static List<Integer> an(int x) {
        List<Integer> list = new ArrayList<>();
        int n = 1;
        int sum = x * x;
        list.add(1);
        for (int i = 2; i <= sum; i++) {
            if (n >= 6) {
                break;
            }
            if (sum % i == 0) {
                list.add(i);
                n = n + 1;
            }
        }
        return list;
    }

    public static int an1(List<Integer> list, int n) {
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        if (list.size() == 1) {
            return n;
        }
        Arrays.sort(a);
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            if (a[i] > a[i - 1] + n) {
                res = res + n;
            } else {
                res = res + (a[i] - a[i - 1]);
            }
        }
        return res + n;
    }

    public static int[] an3(int x) {
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            int a = x % 10;
            list.add(a);
            x = x / 10;
        }
        int[] ax = new int[list.size() * 2];
        int n = list.size();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < n; j++) {
                list.add(list.get(j));
            }
        }
        for (int i = 0; i < ax.length; i++) {
            ax[i] = list.get(i);
        }
        return ax;
    }


    public static void main(String[] args) {
        System.out.println(answer(18));
    }
}
