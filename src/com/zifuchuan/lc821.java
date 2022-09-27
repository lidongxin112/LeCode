package com.zifuchuan;

/**
 * 821. 字符的最短距离
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它
 * 最近 的字符 c 的 距离 。
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 *
 * @author 东鑫
 */
public class lc821 {
    public int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];
        int n = s.length();
        for (int i = 0, idx = -n; i < n; i++) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            answer[i] = i - idx;
        }
        for (int i = n-1, idx = 2 * n; i >=0; i--) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            answer[i] = Math.min(answer[i], idx - i);
        }
        return answer;
    }
    public int[] bfs(String s,char c){

        return null;
    }
    public static void main(String[] args) {

    }
}
