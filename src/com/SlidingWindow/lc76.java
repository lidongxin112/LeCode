package com.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串
 * ，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * @author 东鑫
 */
public class lc76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> ori = new HashMap<>();
        Map<Character, Integer> cnt = new HashMap<>();
        if (s.length() < t.length()) {
            return "";
        }
        int length = t.length();
        for (int i = 0; i < length; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            //右移窗口
            right++;
            if (ori.containsKey(c)) {
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
                if (ori.get(c).equals(cnt.get(c))) {
                    valid++;
                }
            }
            //满足时，进行窗口缩减
            while (valid == ori.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //得出窗口字符
                char d = s.charAt(left);

                left++;
                //判断字符在窗口中
                if (ori.containsKey(d)) {
                    //如果是，需要将valid更新
                    if (cnt.get(d).equals(ori.get(d))) {
                        valid--;
                    }
                    //弹出窗口
                    cnt.put(d, cnt.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = new lc76().minWindow("","");
    }
}
