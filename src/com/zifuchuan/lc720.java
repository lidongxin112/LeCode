package com.zifuchuan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 720. 词典中最长的单词
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，
 * 该单词是由 words 词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 *
 * @author 东鑫
 */
public class lc720 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String s : words) {
            //如果单词只有一个字母，那一定是共有的
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String []words = {"w","wo","wor","worl", "world"};
        String []word = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String s = new lc720().longestWord(words);
        System.out.println(s);
    }
}
