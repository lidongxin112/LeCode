package com.easy;

/**
 * 598. 范围求和 II
 * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
 *
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，
 * 含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
 */
public class lc598 {
    public int maxCount(int m, int n, int[][] ops) {
        int mina = m;
        int minb = n;
        for (int[] op:ops){
            mina = Math.min(mina,op[0]);
            minb = Math.min(minb,op[1]);
        }
        return mina * minb;
    }
}
