package com.stockIssue;

/**
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i]
 * 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class lc188 {
        public int maxProfit(int max_k, int[] prices) {
            int n = prices.length;
            if (n <= 0) {
                return 0;
            }
            if (max_k > n / 2) {
                // 交易次数 k 没有限制的情况
                return maxProfit_k_inf(prices);
            }
            int[][][] dp = new int[n][max_k + 1][2];
            // k = 0 时的 base case
            for (int i = 0; i < n; i++) {
                dp[i][0][1] = Integer.MIN_VALUE;
                dp[i][0][0] = 0;
            }
            for (int i = 0; i < n; i++)
                for (int k = max_k; k >= 1; k--) {
                    if (i - 1 == -1) {
                        // 处理 i = -1 时的 base case
                        dp[i][k][0] = 0;
                        dp[i][k][1] = -prices[i];
                        continue;
                    }
                    // 状态转移方程
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            return dp[n - 1][max_k][0];
        }
        private int maxProfit_k_inf(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            for (int i = 0; i < n; i++) {
                if (i - 1 == -1) {
                    // base case
                    dp[i][0] = 0;
                    dp[i][1] = -prices[i];
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }

    public static void main(String[] args) {

    }
}
