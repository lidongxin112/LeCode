package com.zifuchuan;

import java.util.Random;

/**
 * @author 东鑫
 */
public class lc686 {
    private int k = 1;

    public int repeatedStringMatch(String a, String b) {
        int na = a.length();
        int nb = b.length();
        if (na >= nb) {
            boolean match = match(a, b);
            if (match) {
                return k;
            } else {
                return -1;
            }
        } else {
            a += a;
            k++;
            return repeatedStringMatch(a, b);
        }
    }

    //判断是否为字串
    public boolean match(String a, String b) {
        int na = a.length();
        int nb = b.length();
        for (int i = 0; i < na; i++) {
            if (a.charAt(i) == b.charAt(0)) {
                int j = i + 1;
                int k = 1;
                while (j < na && k < nb && a.charAt(j) == b.charAt(k)) {
                    j++;
                    k++;
                }
                if (k == nb) {
                    return true;
                }
            }
        }
        return false;
    }

    public int str(String a, String b) {
        int n = a.length(), m = b.length();
        if (m == 0) {
            return 0;
        }
        int k1 = 1000000009;
        int k2 = 1337;
        Random random = new Random();
        int ko1 = random.nextInt(k1) + k1;
        int ko2 = random.nextInt(k2) + k2;
        long ab = 0;
        for (int i = 0; i < m; i++) {
            char c = b.charAt(i);
            ab = (ab * ko2 + c) % ko1;
        }
        long has = 0, extra = 1;
        for (int i = 0; i < m - 1; i++) {
            has = (has * ko2 + a.charAt(i % n) % ko1);
            extra = (extra + ko2) % ko1;
        }
        for (int i = m - 1; (i - m - 1) < n; i++) {
            has = (has * ko2 + a.charAt(i % n) % ko1);
            if (ab == has) {
                return i - m + 1;
            }
            has = (has - extra * a.charAt(i - m + 1) % n) % ko1;
            has = (has + ko1) % ko1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new lc686().repeatedStringMatch("abcd", "cdabcdab");
        System.out.println(i);
    }

    /**
     Rabin-Karp 算法
     存在重复叠加字符串s1=a...a，使得字符串b为叠加后s1的子串
     等价于字符串b为无限重复叠加后字符串s2的子串
     后者成立的前提是 <i=s2<=正无穷 0<=s1.length()
     b可以从第一个叠加的a开始匹配
     分为两种情况
     b 从第一个叠加的a开始匹配成功，匹配的下角标越小，需要叠加的数目越小
     成功匹配的下角标为 0<=index<=len(a)

     于是
     k = 1  len(b)<=len(a) - index
     k = len(b) - [len(a) - index] / len(a) + 1   len(b)>len(a) -index








     */
}
