package y2026.May;

import static java.util.Collections.rotate;

/**
 * 796. 旋转字符串
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 *
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 *
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, goal.length <= 100
 */
public class lc796 {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m){
            return false;
        }
        if (s.equals(goal)){
            return true;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) == goal.charAt(j)) {
                    if (j == n - 1) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new lc796().rotateString("abcde", "cdeab"));
    }
}
