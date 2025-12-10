package reactInterview;

import java.util.*;

public class day4 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *      0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     生成所有可能的子字符串，并检查每个子字符串是否有效，并据此不断更新 maxLen。
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
//    public int lengthOfLongestSubstring2(String s) {
//        int[] index = new int[128];
//        int left = 0, right = 0;
//        int maxLen = 0;
//        while (right < s.length()) {
//            char c = s.charAt(right);
//            index[c]++;
//            right++;
//            while (index[c] > 1) {
//                char d = s.charAt(left);
//                index[d]--;
//                left++;
//            }
//        }
//        return Math.max(maxLen, right - left);
//    }

    public static void main(String[] args) {
        System.out.println(new day4().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new day4().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new day4().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new day4().lengthOfLongestSubstring(""));

//        System.out.println(new day4().lengthOfLongestSubstring2("abcabcbb"));
//        System.out.println(new day4().lengthOfLongestSubstring2("bbbbb"));
//        System.out.println(new day4().lengthOfLongestSubstring2("pwwkew"));
//        System.out.println(new day4().lengthOfLongestSubstring2(""));
    }
}
