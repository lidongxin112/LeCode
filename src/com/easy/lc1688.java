package com.easy;

/**
 * @author 东鑫
 */
public class lc1688 {
    static int a = 0;

    public int numberOfMatches(int n) {
        int[] a = new int[n + 1];
        int b = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                a[i] = 0;
            }
            a[i] = i / 2;
        }
        while (n > 1) {
            b += a[n];
            boolean yb = n % 2 == 0;
            n = yb == true ? n / 2 : n / 2 + 1;
        }
        return b;
    }

    public static void main(String[] args) {
        int i = new lc1688().numberOfMatches(7);
        System.out.println(i);
    }
}
