package com.zifuchuan;

/**
 * @author 东鑫
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，
 * 使最终的字符串不包含任何 连续重复 的字符。
 * <p>
 * 注意：你 不能 修改非 '?' 字符。
 * <p>
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * <p>
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。
 * 可以证明，在给定的约束条件下，答案总是存在的。
 */
public class lc1576 {
    public String modifyString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                char c = 'a';
                while ((i > 0 && chars[i - 1] == c) || (i < n - 1 && chars[i + 1] == c)) {
                    c++;
                }
                chars[i] = c;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "??z?";
        String s1 = new lc1576().modifyString(s);
        System.out.println(s1);
    }
}
