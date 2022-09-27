package com.dynamicProgramming;

/**
 * 39. 解码方法 II
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" 对应分组 (1 1 10 6)
 * "KJF" 对应分组 (11 10 6)
 */
public class lc639 {
    public static final int MOD = 1000000007;

    public int numDecodings(String s) {
        int n = s.length();
        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; i++) {
            c = b * checkldidgit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * check2digits(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    public int checkldidgit(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    public int check2digits(char c0, char c1) {
        if (c0 == '*' && c1 == '*') {
            return 15;
        }
        if (c0 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c0 == '1') {
                return 9;
            }
            if (c0 == '2') {
                return 6;
            }
            return 0;
        }
        return (c0 != '0' && (c0 - '0') * 10 + (c1 - '0') <= 26) ? 1 : 0;
    }

    public static void main(String[] args) {
        String s = "*******";
        int i = new lc639().numDecodings(s);
        System.out.println(i);
    }
}
