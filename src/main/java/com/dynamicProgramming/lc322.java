package com.dynamicProgramming;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class lc322 {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);

        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == 1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int dp1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -666) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int sub = dp(coins, amount - coins[i]);
            if (sub == 1) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    public static void main(String[] args) {
        int[] coin = {1, 2, 5};
        int i = new lc322().coinChange(coin, 11);
        System.out.println(i);
    }
}
