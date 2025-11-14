package com.math;

/**
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 */
public class lc258 {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        /**
         * 11
         * 10 % 9 +1 = 2
         * 2
         * 22
         * 2 * 10 + 2
         * 21 % 9 +1 = 4
         * 4
         * 2
         *
         *
         */
    }
}
