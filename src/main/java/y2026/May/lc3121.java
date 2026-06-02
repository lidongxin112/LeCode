package y2026.May;

import java.util.Arrays;

/**
 * 3121. 统计特殊字母的数量 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称字母 c 是一个 特殊字母 。
 * <p>
 * 返回 word 中 特殊字母 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：word = "aaAbcBC"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 特殊字母是 'a'、'b' 和 'c'。
 * <p>
 * 示例 2:
 * <p>
 * 输入：word = "abc"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * word 中不存在特殊字母。
 * <p>
 * 示例 3:
 * <p>
 * 输入：word = "AbBCab"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * word 中不存在特殊字母。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 2 * 105
 * word 仅由小写和大写英文字母组成。
 */
public class lc3121 {
    public int numberOfSpecialChars(String word) {
        int[] ans = new int[52];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                if (ans[c - 'A'] == 0) {
                    ans[c - 'A'] = i + 1;
                }
            } else {
                    ans[26 + c - 'a'] = i + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (ans[i] > ans[26 + i] && ans[26 + i] != 0) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new lc3121().numberOfSpecialChars("aaAbcBC"));
        System.out.println(new lc3121().numberOfSpecialChars("AbBCab"));
    }
}
