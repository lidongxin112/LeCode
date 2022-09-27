package com.zifuchuan;

import java.util.HashSet;
import java.util.Set;

/**
 * 564. 寻找最近的回文数
 * 给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
 * “最近的”定义为两个整数差的绝对值最小。
 *
 * @author 东鑫
 */
public class lc564 {
    public String nearestPalindromic(String n) {
        Long b = Long.valueOf(n);
        int c = n.length();
        Set<Long> set = new HashSet<>();
        set.add((long) (Math.pow(10, (c - 1)) - 1));
        set.add((long) (Math.pow(10, c) + 1));
        long t = Long.parseLong(n.substring(0, (c + 1) / 2));
        for (long i = t - 1; i <= t + 1; i++) {
            long temp = -1;
            if (c % 2 == 0) {
                temp = getNum(i, true);
            } else {
                temp = getNum(i, false);
            }
            if (temp != b) {
                set.add(temp);
            }
        }
        long ans = -1;
        for (long i : set) {
            if (ans == -1) {
                ans = i;
            } else if (Math.abs(i - b) < Math.abs(ans - b)) {
                ans = i;
            } else if (Math.abs(i - b) == Math.abs(ans - b) && i < ans) {
                ans = i;
            }
        }
        return String.valueOf(ans);
    }

    long getNum(long k, boolean isEven) {
        StringBuilder sb = new StringBuilder();
        sb.append(k);
        int idx = isEven ? sb.length() - 1 : sb.length() - 2;
        while (idx >= 0) {
            sb.append(sb.charAt(idx--));
        }
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        String s = new lc564().nearestPalindromic("1");
        System.out.println(s);
    }
}
