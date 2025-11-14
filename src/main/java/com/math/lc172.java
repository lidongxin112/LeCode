package com.math;

/**
 * @author 东鑫
 */
public class lc172 {

    public int trailingZeroes(int n) {
        int res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res +=n / divisor;
            divisor*=5;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new lc172().trailingZeroes(5);
    }
}
