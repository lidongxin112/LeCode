package com.zifuchuan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 东鑫
 * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的
 * 最短补全词 。
 * <p>
 * 补全词 是一个包含 licensePlate 中所有的字母的单词。在所有补全词中，最短的那个就是
 * 最短补全词 。
 * <p>
 * 在匹配 licensePlate 中的字母时：
 * <p>
 * 忽
 * licensePlate 中的 数字和空格 。
 * 不区分大小写。
 * 如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
 * 请你找出并返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 最靠前的 那个。
 */
public class lc748 {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            int[] cnt = new int[26];
            for (int i = 0; i < licensePlate.length(); ++i) {
                char ch = licensePlate.charAt(i);
                if (Character.isLetter(ch)) {
                    ++cnt[Character.toLowerCase(ch) - 'a'];
                }
            }
            int idx = -1;
            for (int i = 0; i < words.length; ++i) {
                int[] c = new int[26];
                for (int j = 0; j < words[i].length(); ++j) {
                    char ch = words[i].charAt(j);
                    ++c[ch - 'a'];
                }
                boolean ok = true;
                for (int j = 0; j < 26; ++j) {
                    if (c[j] < cnt[j]) {
                        ok = false;
                        break;
                    }
                }
                if (ok && (idx < 0 || words[i].length() < words[idx].length())) {
                    idx = i;
                }
            }
            return words[idx];
        }

    public static void main(String[] args) {
        String[] words = {"step", "steps", "stripe", "stepple"};
//        String s1 = new lc748().shortestCompletingWord("1s3 PSt", words);
//        System.out.println(s1);
        String s = "pst";
//        String s2 = "step";
//        boolean con = new lc748().con(s, s2);
//        System.out.println(con);

    }
}
