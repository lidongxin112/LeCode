package y2026.May;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1871. 跳跃游戏 VII
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时满足如下条件时，你可以从下标 i 移动到下标 j 处：
 *
 * i + minJump <= j <= min(i + maxJump, s.length - 1) 且
 * s[j] == '0'.
 * 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "011010", minJump = 2, maxJump = 3
 * 输出：true
 * 解释：
 * 第一步，从下标 0 移动到下标 3 。
 * 第二步，从下标 3 移动到下标 5 。
 * 示例 2：
 *
 * 输入：s = "01101110", minJump = 2, maxJump = 3
 * 输出：false
 *
 *
 * 提示：
 *
 * 2 <= s.length <= 105
 * s[i] 要么是 '0' ，要么是 '1'
 * s[0] == '0'
 * 1 <= minJump <= maxJump < s.length
 */
public class lc1871 {
    public boolean canReach1(String s, int minJump, int maxJump) {
        char[] charArray = s.toCharArray();
        boolean [] visited = new boolean[charArray.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = cur + minJump; i <= Math.min(cur + maxJump, charArray.length - 1); i++) {
                if (charArray[i] == '0' && !visited[i]) {
                    if (i == charArray.length - 1) {
                        return true;
                    }
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        if (charArray[n - 1] == '1'){
            return false;
        }
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (i - minJump >= 0 && dp[i - minJump]){
                cnt++;
            }
            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]){
                cnt--;
            }
            if (charArray[i] == '0' && cnt > 0){
                dp[i] = true;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new lc1871().canReach("011010", 2, 3));
        System.out.println(new lc1871().canReach("01101110", 2, 3));
        System.out.println(new lc1871().canReach("01101110", 1, 2));
    }
}
