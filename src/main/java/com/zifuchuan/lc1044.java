package com.zifuchuan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 东鑫
 * 1044. 最长重复子串
 * 给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。
 * 这些出现之间可能存在重叠。
 *
 * 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。
 */
public class lc1044 {
    public String longestDupSubstring(String s) {
        Set<Character> set = new HashSet<>();
        for (char as:s.toCharArray()){
            set.add(as);
        }
        if (set.size()>=s.length()){
            return "";
        }
        return "a";
    }

    public static void main(String[] args) {
        String abcd = new lc1044().longestDupSubstring("abcd");
        System.out.println(abcd);
    }
}
