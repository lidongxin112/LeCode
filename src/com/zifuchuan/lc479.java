package com.zifuchuan;

/**
 * 479. 最大回文数乘积
 * 给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 * @author 东鑫
 */
public class lc479 {
    public int largestPalindrome(int n) {
        if (n==1){
            return 9;
        }
        int upper = (int) (Math.pow(10,n) - 1);
        int ans = 0;
        for (int left = upper; ans == 0; --left) { // 枚举回文数的左半部分
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数 p
            }
            System.out.println(p);
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) { // x 是 p 的因子
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new lc479().largestPalindrome(2);
    }
}
