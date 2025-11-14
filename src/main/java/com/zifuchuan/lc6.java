package com.zifuchuan;

import java.util.HashMap;
import java.util.Map;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * 14    7 14/3 = 6
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。PAHNAPLSIIGYIR
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * @author 东鑫
 */
public class lc6 {
    //1 0 2 4 3 7 4 10   4 3 3
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n <= 1 || numRows > n) {
            return s;
        }
        int k = (2 * numRows - 2) == 0 ? 1 : (2 * numRows - 2);
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            int j = i % k;

            if (j <= numRows - 1) {
                String b = map.get(j) != null ? map.get(j) : "";
                map.put(j, b + s.charAt(i));
            } else {
                int m = 2 * numRows - 2 - j;
                String b = map.get(m) != null ? map.get(m) : "";
                map.put(m, b + s.charAt(i));
            }
        }
        StringBuilder suild = new StringBuilder();
        for (String a : map.values()) {
            suild.append(a);
        }
        return suild.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i += (numRows - 1) * 2) {
            ans.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = 0; j * (numRows - 1) * 2 + i < s.length(); j++) {
                ans.append(s.charAt(j * (numRows - 1) * 2 + i));
                int r = (j + 1) * (numRows - 1) * 2 - i;
                if (r < s.length()) {
                    ans.append(s.charAt(r));
                }
            }
        }
        for (int i = numRows - 1; i < s.length(); i += (numRows - 1) * 2) {
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "PA";
        String convert = new lc6().convert(s, 1);
        System.out.println(convert);
    }
}
