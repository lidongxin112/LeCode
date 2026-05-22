package y2026.May;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        char[] array = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        for (int left = 0,right = 0; left < array.length; left++){

            while (right < array.length && right - left < p.length()){
                right++;
            }
            if (right - left == p.length()){
                if (isAnagram(s.substring(left, right), p)){
                    res.add(left);
                }
            }
        }
        return res;
    }

    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        for (char a : s.toCharArray()) {
            cnt[a - 'a']++;
        }
        for (char a : t.toCharArray()) {
            cnt[a - 'a']--;
        }
        for (int i : cnt) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();  //  arraylist是有序的，有索引的
        int[] sCount = new int[26];  // 整数，记录26个小写字母的索引，a对应索引0，b对应索引1..... 每个索引对应的值，为该字母出现的次数，初始次数都是0；
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) { // 按照p字符数组的长度去遍历
            ++sCount[s.charAt(i) - 'a']; // s.chartAt(i)得到此处的字母，-"a"，得到该字母的索引，++表示统计该字母的出现次数。
            ++pCount[p.charAt(i) - 'a'];
        }
        //判断放置处是否有异位词。若相等，则表明s的前几位就是p的异位词。起始索引即为0.
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a']; // 减去滑动窗口的第0位，即，窗口变为1，2
            ++sCount[s.charAt(i + pLen) - 'a']; // 加上窗口的第plen位(第3位)，即，窗口变为1，2，3
            // 完成了一次滑动窗口
            // 若相等，存在异位词，起始索引为i+1
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new lc438().findAnagrams2("cbaebabacd", "abc"));
        System.out.println(new lc438().findAnagrams2("abab", "ab"));
    }
}
