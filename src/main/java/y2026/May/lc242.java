package y2026.May;

public class lc242 {
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
}
