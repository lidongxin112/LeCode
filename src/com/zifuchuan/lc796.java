package com.zifuchuan;

/**
 * 796. 旋转字符串
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 *
 * @author 东鑫
 */
public class lc796 {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) {
            return false;
        }
        if (s.equals(goal)) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            if (rotate(s).equals(goal)) {
                s = rotate(s);
                return true;
            }
            s = rotate(s);
        }
        return false;
    }

    public String rotate(String s) {
        String so = s.substring(1, s.length()) + s.charAt(0);
        return so;
    }

    public static void main(String[] args) {
        boolean b = new lc796().rotateString("abcde", "cdeab");
        System.out.println(b);
    }
}
