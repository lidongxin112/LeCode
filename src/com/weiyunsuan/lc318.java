package com.weiyunsuan;

import java.util.ArrayList;
import java.util.List;

/**
 * 318. 最大单词长度乘积
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 *
 * @author 东鑫
 */
public class lc318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int [] hash = new int[n];
        int max = 0;
        for (int i=0;i<n;i++){
            for (char c:words[i].toCharArray()){
                hash[i] |= 1<<(c-'a');
            }
        }
        for (int i=0;i<n-1;i++){
             for (int j=i+1;j<n;j++){
                 if ((hash[i]&hash[j])==0){
                     max = Math.max(words[i].length() *words[j].length(),max);
                 }
             }
        }
        return max;
    }
//    public String same(String a, String b){
//        for (int i=0;i<a.length();i++){
//            for (int j=0;j<b.length();j++){
//                if (a.charAt(i)==b.charAt(j)){
//                    break;
//                }
//            }
//        }
//        return a.length()>=b.length()?a:b;
//    }
//class Solution {
//    public int maxProduct(String[] words) {
//        int n = words.length;
//        int[][] wordLength = new int[n][27];
//        for (int i = 0; i < n; i++) {
//            String word = words[i];
//            for (char c : word.toCharArray()) {
//                wordLength[i][c - 'a']++;
//            }
//            wordLength[i][26] = word.length();
//        }
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (helper(wordLength[i], wordLength[j])) {
//                    ans = Math.max(ans, wordLength[i][26] * wordLength[j][26]);
//                }
//            }
//        }
//        return ans;
//    }
//
//    private boolean helper(int[] chars1, int[] chars2) {
//        for (int i = 0; i < 26; i++) {
//            if (chars1[i] != 0 && chars2[i] != 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
    public static void main(String[] args) {
        String [] aa = {"abcw","baz","foo","bar","xtfn","abcdef"};
        int i = new lc318().maxProduct(aa);

    }
}
