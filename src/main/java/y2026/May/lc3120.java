package y2026.May;

/**
 * 给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母 。
 *
 * 返回 word 中 特殊字母 的数量。
 */
public class lc3120 {
    public int numberOfSpecialChars(String word) {
        int[] ans = new int[52];
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                ans[c - 'A']++;
            } else {
                ans[c - 'a' + 26]++;
            }
        }
        int sum = 0;
        for (int i = 0; i <26; i++) {
            if (ans[i] > 0 && ans[i + 26] > 0) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println('A' - 'a');
        System.out.println(new lc3120().numberOfSpecialChars("s"));
        System.out.println(new lc3120().numberOfSpecialChars("aA"));
        System.out.println(new lc3120().numberOfSpecialChars("bB"));
        System.out.println(new lc3120().numberOfSpecialChars("c"));

    }
}
