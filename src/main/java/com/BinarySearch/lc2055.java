package com.BinarySearch;


import java.util.ArrayList;
import java.util.List;

/**
 * 2055. 蜡烛之间的盘子
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，
 * 其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 * <p>
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti]
 * 表示子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间
 * 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 * <p>
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。
 * 子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 */
public class lc2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] lefts = new int[n + 1];
        int[] rights = new int[n + 1];
        int[] candles = new int[n + 1];
        lefts[0] = -1;
        rights[n] = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|' && i == 0 || s.charAt(i) == '|' && s.charAt(i - 1) != '|') {
                lefts[i + 1] = i;
            } else {
                lefts[i + 1] = lefts[i];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|' && i == n - 1 || s.charAt(i) == '|' && s.charAt(i + 1) != '|') {
                rights[i] = i;
            } else {
                rights[i] = rights[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            candles[i + 1] = candles[i];
            if (s.charAt(i) == '|') {
                candles[i + 1] += 1;
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // 查询左端找最右，查询右端找最左
            int le = rights[queries[i][0]];
            int ri = lefts[queries[i][1] + 1];
            if (le < ri) {
                res[i] = ri - le - 1 - (candles[ri + 1] - candles[le + 1] - 1);
            }
        }
        return res;
    }

    public int[] plate1(String s, int[][] qs) {
        char[] cs = s.toCharArray();
        int n = cs.length, m = qs.length;
        int[] ans = new int[m], sum = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '|') list.add(i);
            sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
        }
        if (list.size() == 0) return ans;
        for (int i = 0; i < m; i++) {
            int a = qs[i][0], b = qs[i][1];
            int c = -1, d = -1;
            // 找到 a 右边最近的蜡烛
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (list.get(mid) >= a) r = mid;
                else l = mid + 1;
            }
            if (list.get(r) >= a) c = list.get(r);
            else continue;
            // 找到 b 左边最近的蜡烛
            l = 0;
            r = list.size() - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid) <= b) l = mid;
                else r = mid - 1;
            }
            if (list.get(r) <= b) d = list.get(r);
            else continue;
            if (c <= d) ans[i] = sum[d + 1] - sum[c];
        }
        return ans;
    }

    public int[] plate(String s, int[][] qs) {
        char[] cs = s.toCharArray();
        int n = cs.length, m = qs.length;
        int[] l = new int[n], r = new int[n];
        int[] sum = new int[n + 1];
        for (int i = 0, j = n - 1, p = -1, q = -1; i < n; i++, j--) {
            if (cs[i] == '|') p = i;
            if (cs[j] == '|') q = j;
            l[i] = p;
            r[j] = q;
            sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int a = qs[i][0], b = qs[i][1];
            int c = r[a], d = l[b];
            if (c != -1 && c <= d) ans[i] = sum[d + 1] - sum[c];
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "**|**|***|";
        int[][] grad = {{2, 5}, {5, 9}};
        int[] ints = new lc2055().plate1(s, grad);
        for (int i : ints) {
            System.out.println(i);
        }
    }


}
