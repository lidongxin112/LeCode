package com.stockIssue;

/**
 * @author 东鑫
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
 * <p>
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股股票。
 * 你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
public class lc122 {
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
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] - prices[i]);
        }
        return dp[n-1][0];
    }


    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        int i = new lc122().maxProfit(prices);
        System.out.println(i);
    }
}
