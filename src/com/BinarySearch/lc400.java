package com.BinarySearch;

/**
 * 400. 第 N 位数字
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...]
 * 中找出并返回第 n 位数字。
 *
 * @author 东鑫
 */
public class lc400 {
    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int dig = index % d;
        int digit = (num / (int) (Math.pow(10, d - dig - 1))) % 10;
        return digit;
    }

    public static void main(String[] args) {
        int nthDigit = new lc400().findNthDigit(11);
        System.out.println(nthDigit);
    }
}
