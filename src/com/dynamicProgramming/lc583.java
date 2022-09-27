package com.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 */
public class lc583 {
    public int minDistance(String word1, String word2) {
        int i = longestCommonSubsequence(word1, word2);
        int a = 0;
        a+=word1.length() - i + word2.length() - i;
        return a;
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            char c1 = text1.charAt(i-1);
            for (int j=1;j<=n;j++){
                char c2 =text2.charAt(j-1);
                if (c1==c2){
                    dp[i][j] += dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "abc";
        String b ="bct";
        int i = new lc583().minDistance(s, b);
        System.out.println(i);
    }
}
