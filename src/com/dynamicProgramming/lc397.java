package com.dynamicProgramming;

/**
 * 给定一个正整数n ，你可以做如下操作：
 * <p>
 * 如果n是偶数，则用n / 2替换n 。
 * 如果n是奇数，则可以用n + 1或n - 1替换n 。
 * n变为 1 所需的最小替换次数是多少？
 *
 * @author 东鑫
 */
public class lc397 {
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        } else {
            return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
        }
    }

    public static void main(String[] args) {
        int i = new lc397().integerReplacement(7);
        System.out.println(i);
    }
}
