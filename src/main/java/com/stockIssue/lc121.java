package com.stockIssue;

/**
 * @author 东鑫
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class lc121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    public int max(int[] prices) {
        int n = prices.length;
        int dp1 = 0, dp2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp1 = Math.max(dp1, dp2 + prices[i]);
            dp2 = Math.max(dp1, -prices[i]);
        }
        return dp1;
    }

    public static void main(String[] args) {
        int[] pri = {7, 1, 5, 3, 6, 4};
        int a = new lc121().maxProfit(pri);
        System.out.println(a);
    }
}
