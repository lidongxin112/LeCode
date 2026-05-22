package y2026.aud;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class lcdd {
    public int legthLongSetSubString(String s){
        int n = s.length();
        List<Character> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++){
            if (!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
                max = Math.max(max, list.size());
            }else {
                i = i - 1;
                list = new ArrayList<>();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new lcdd().legthLongSetSubString("abcabcbb"));
        System.out.println(new lcdd().legthLongSetSubString("bbbbb"));
        System.out.println(new lcdd().legthLongSetSubString("pwwkew"));
    }
}
