package reactInterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day2 {
    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 解释：
     * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
     * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
     * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0) {
            return ans;
        }
        for (int i = 0; i < strs.length; i++) {
            Set<String> list1 = new HashSet<>();
            Set<String> list2 = new HashSet<>();
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[i].length() == strs[j].length()) {
                    if (isAnagram(strs[i], strs[j])) {
                        list1.add(strs[i]);
                        list1.add(strs[j]);
                    } else {
                        list2.add(strs[i]);
                    }
                } else {
                    continue;
                }
            }
            if (!list1.isEmpty()){
                ans.add(list1.stream().toList());
            }
            if (!list2.isEmpty()){
                ans.add(list2.stream().toList());
            }
        }
        return ans;
    }

    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        for (char a : s.toCharArray()) {
            cnt[a - 'a']++;
        }
        for (char a : t.toCharArray()) {
            cnt[a - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new day2().groupAnagrams(strs));
    }

}
