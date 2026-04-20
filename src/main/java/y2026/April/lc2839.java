package y2026.April;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给你两个字符串 s1 和 s2 ，两个字符串的长度都为 4 ，且只包含 小写 英文字母。
 * 你可以对两个字符串中的 任意一个 执行以下操作 任意 次：
 * 选择两个下标 i 和 j 且满足 j - i = 2 ，然后 交换 这个字符串中两个下标对应的字符。
 * 如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false
 * 示例 1：
 * 输入：s1 = "abcd", s2 = "cdab"
 * 输出：true
 * 解释： 我们可以对 s1 执行以下操作：
 * - 选择下标 i = 0 ，j = 2 ，得到字符串 s1 = "cbad" 。
 * - 选择下标 i = 1 ，j = 3 ，得到字符串 s1 = "cdab" = s2 。
 * 示例 2：
 * 输入：s1 = "abcd", s2 = "dacb"
 * 输出：false
 * 解释：无法让两个字符串相等。
 * s1.length == s2.length == 4
 * s1 和 s2 只包含小写英文字母。
 */
public class lc2839 {
    public boolean canBeEqual(String s1, String s2) {
        String s11 = s1.charAt(2) + s1.substring(1,2) + s1.charAt(0) + s1.charAt(3);
        String s12 = s1.charAt(0) + s1.substring(3) + s1.charAt(2) + s1.charAt(1);
        String s13 = s1.substring(2,3) + s1.charAt(3) + s1.charAt(0) + s1.charAt(1);

        String s21 = s2.charAt(2) + s2.substring(1,2) + s2.charAt(0) + s2.charAt(3);
        String s22 = s2.charAt(0) + s2.substring(3) + s2.charAt(2) + s2.charAt(1);
        String s23 = s2.substring(2,3) + s2.charAt(3) + s2.charAt(0) + s2.charAt(1);

        return s1.equals(s2) || s11.equals(s2) || s12.equals(s2) || s13.equals(s2) || s21.equals(s1) || s22.equals(s1) || s23.equals(s1);
    }

    public boolean canBeEqual2(String s1, String s2) {
        // 检查 0 ↔ 2 组
        boolean group1 = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2))
                || (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));

        // 检查 1 ↔ 3 组
        boolean group2 = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3))
                || (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));

        return group1 && group2;
    }
    public boolean canBeEqual3(String s1, String s2) {
        int []even = new int[26];
        int []odd = new int[26];

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }
        even[s1.charAt(0) - 'a']++;
        even[s1.charAt(2) - 'a']++;
        even[s2.charAt(0) - 'a']--;
        even[s2.charAt(2) - 'a']--;

        odd[s1.charAt(1) - 'a']++;
        odd[s1.charAt(3) - 'a']++;
        odd[s2.charAt(1) - 'a']--;
        odd[s2.charAt(3) - 'a']--;
        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        boolean b = new lc2839().canBeEqual2("abcd", "cdab");
        boolean c = new lc2839().canBeEqual3("abcd", "cdab");

        System.out.println(b);
        System.out.println(c);
    }
}
