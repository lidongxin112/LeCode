package com.easy;

/**
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 */
public class lc367 {
    public boolean isPerfectSquare(int num) {
        if (num==1){
            return true;
        }
        int n = num / 2;
        int a = 1;
        int b = n;
        while (a<=n) {
            int c = ((b - a) >> 1) + a;
            int t = num / c;
            if (t == c) {
                if (num % c==0) {
                    return true;
                } else if (c * c < num) {
                    b = c - 1;
                } else {
                    a = c + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean perfectSquare = new lc367().isPerfectSquare(14);
        System.out.println(perfectSquare);


    }
}
