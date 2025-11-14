package com.stockIssue;

/**
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class lc123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int mak = k;mak >= 1; mak--) {
                if (i - 1 == -1) {
                    dp[i][mak][0] = 0;
                    dp[i][mak][1] = -prices[i];
                    continue;
                }
                dp[i][mak][0] = Math.max(dp[i - 1][mak][0], dp[i - 1][mak][1] + prices[i]);
                dp[i][mak][1] = Math.max(dp[i - 1][mak][1], dp[i - 1][mak - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
    public int maxProfif(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int mak = k;mak >= 1; mak--) {
                if (i - 1 == -1) {
                    dp[i][mak][0] = 0;
                    dp[i][mak][1] = -prices[i];
                    continue;
                }
                dp[i][mak][0] = Math.max(dp[i - 1][mak][0], dp[i - 1][mak][1] + prices[i]);
                dp[i][mak][1] = Math.max(dp[i - 1][mak][1], dp[i - 1][mak - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }


    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int i = new lc123().maxProfit(prices);
        System.out.println(i);
    }
}
