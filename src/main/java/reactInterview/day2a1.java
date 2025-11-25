package reactInterview;

import java.util.*;

public class day2a1 {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
     * 字母异位词是通过重新排列不同单词或短语的字母而形成的单词或短语，并使用所有原字母一次。
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int [] cnt = new int[26];
        for (char a : s.toCharArray()) {
            cnt[a - 'a']++;
        }
        for (char a : t.toCharArray()){
            cnt[a - 'a']--;
        }
        for (int i = 0; i < 26; i++){
            if (cnt[i] != 0){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram3(String s, String t) {
        Set<String> set = new HashSet<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        set.add(new String(chars));
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars1);
        return set.contains(new String(chars1));
    }

    public boolean isAnagramT(String s, String t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (char a : s.toCharArray()) {
            map.put(a - 'a', map.getOrDefault(a - 'a', 0) + 1);
        }
        for (char a : t.toCharArray()){
            map.put(a - 'a', map.getOrDefault(a - 'a', 0) - 1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new day2a1().isAnagramT("anagram", "nagaram"));
        System.out.println(new day2a1().isAnagram("rat", "car"));
        System.out.println(new day2a1().isAnagram("a", "ab"));
    }
}
