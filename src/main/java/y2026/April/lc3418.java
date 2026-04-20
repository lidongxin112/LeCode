package y2026.April;

import java.util.Arrays;

/**
 * 3418. 机器人可以获得的最大金币数
 * 给你一个 m x n 的网格。一个机器人从网格的左上角 (0, 0) 出发，目标是到达网格的右下角 (m - 1, n - 1)。在任意时刻，机器人只能向右或向下移动。
 * 网格中的每个单元格包含一个值 coins[i][j]：
 * 如果 coins[i][j] >= 0，机器人可以获得该单元格的金币。
 * 如果 coins[i][j] < 0，机器人会遇到一个强盗，强盗会抢走该单元格数值的 绝对值 的金币。
 * 机器人有一项特殊能力，可以在行程中 最多感化 2个单元格的强盗，从而防止这些单元格的金币被抢走。
 * 注意：机器人的总金币数可以是负数。
 * 返回机器人在路径上可以获得的 最大金币数 。
 * 示例 1：
 * 输入： coins = [[0,1,-1],[1,-2,3],[2,-3,4]]
 * 输出： 8
 * 解释：
 * 一个获得最多金币的最优路径如下：
 * 从 (0, 0) 出发，初始金币为 0（总金币 = 0）。
 * 移动到 (0, 1)，获得 1 枚金币（总金币 = 0 + 1 = 1）。
 * 移动到 (1, 1)，遇到强盗抢走 2 枚金币。机器人在此处使用一次感化能力，避免被抢（总金币 = 1）。
 * 移动到 (1, 2)，获得 3 枚金币（总金币 = 1 + 3 = 4）。
 * 移动到 (2, 2)，获得 4 枚金币（总金币 = 4 + 4 = 8）。
 * 示例 2：
 * 输入： coins = [[10,10,10],[10,10,10]]
 * 输出： 40
 * 解释：
 * 一个获得最多金币的最优路径如下：
 * 从 (0, 0) 出发，初始金币为 10（总金币 = 10）。
 * 移动到 (0, 1)，获得 10 枚金币（总金币 = 10 + 10 = 20）。
 * 移动到 (0, 2)，再获得 10 枚金币（总金币 = 20 + 10 = 30）。
 * 移动到 (1, 2)，获得 10 枚金币（总金币 = 30 + 10 = 40）。
 * m == coins.length
 * n == coins[i].length
 * 1 <= m, n <= 500
 * -1000 <= coins[i][j] <= 1000
 */
public class lc3418 {
    //它的状态转移方程是 dp[i][j][k] = max(dp[i-1][j][k-1], dp[i][j-1][k-1]) + coins[i][j]
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int NEG_INF = Integer.MIN_VALUE / 2;

        // dp[i][j][k] = 到达 (i,j) 时，恰好使用 k 次感化的最大金额
        int[][][] dp = new int[m][n][3];

        for (int[][] row : dp) {
            for (int[] cell : row) {
                Arrays.fill(cell, NEG_INF);
            }
        }

        // 起点
        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                for (int k = 0; k <= 2; k++) {
                    // 1. 不感化当前格子
                    int prevMax = NEG_INF;
                    if (i > 0) prevMax = Math.max(prevMax, dp[i - 1][j][k]);
                    if (j > 0) prevMax = Math.max(prevMax, dp[i][j - 1][k]);

                    if (prevMax != NEG_INF) {
                        dp[i][j][k] = prevMax + coins[i][j];
                    }

                    // 2. 感化当前格子
                    if (coins[i][j] < 0 && k > 0) {
                        int prevMaxWithLessK = NEG_INF;
                        if (i > 0) prevMaxWithLessK = Math.max(prevMaxWithLessK, dp[i - 1][j][k - 1]);
                        if (j > 0) prevMaxWithLessK = Math.max(prevMaxWithLessK, dp[i][j - 1][k - 1]);

                        if (prevMaxWithLessK != NEG_INF) {
                            dp[i][j][k] = Math.max(dp[i][j][k], prevMaxWithLessK);
                        }
                    }
                }
            }
        }

        return Math.max(dp[m - 1][n - 1][0],
                Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
    public int maximumAmount2(int[][] coins) {
        int n = coins[0].length;
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE / 2);
        }

        for (int i = 0; i < 3; i++) {
            dp[1][i] = 0;
        }
        for (int[] row : coins) {
            for (int j = 1; j <= n; j++) {
                int x = row[j - 1];
                dp[j][2] = Math.max(Math.max(dp[j - 1][2] + x, dp[j][2] + x),
                        Math.max(dp[j - 1][1], dp[j][1]));
                dp[j][1] = Math.max(Math.max(dp[j - 1][1] + x, dp[j][1] + x),
                        Math.max(dp[j - 1][0], dp[j][0]));
                dp[j][0] = Math.max(dp[j - 1][0], dp[j][0]) + x;
            }
        }

        return dp[n][2];
    }
        public int maximumAmount3(int[][] coins) {
            int m = coins.length, n = coins[0].length;
            int[][][] dp = new int[m][n][3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        if (coins[i][j] >= 0) {
                            dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = coins[i][j];
                        } else {
                            dp[i][j][0] = coins[i][j];
                            dp[i][j][1] = dp[i][j][2] = 0;
                        }
                    } else if (i == 0) {
                        dp[i][j][0] = dp[i][j - 1][0] + coins[i][j];
                        dp[i][j][1] = Math.max(dp[i][j - 1][0], dp[i][j - 1][1] + coins[i][j]);
                        dp[i][j][2] = Math.max(dp[i][j - 1][1], dp[i][j - 1][2] + coins[i][j]);
                    } else if (j == 0) {

                        dp[i][j][0] = dp[i - 1][j][0] + coins[i][j];
                        dp[i][j][1] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + coins[i][j]);
                        dp[i][j][2] = Math.max(dp[i - 1][j][1], dp[i - 1][j][2] + coins[i][j]);
                    } else {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) + coins[i][j];
                        dp[i][j][1] = Math.max(Math.max(dp[i - 1][j][0], dp[i][j - 1][0]),
                                Math.max(dp[i - 1][j][1], dp[i][j - 1][1]) + coins[i][j]);
                        dp[i][j][2] = Math.max(Math.max(dp[i - 1][j][1], dp[i][j - 1][1]),
                                Math.max(dp[i - 1][j][2], dp[i][j - 1][2]) + coins[i][j]);
                    }
                }
            }

            return dp[m - 1][n - 1][2];
        }

    public static void main(String[] args) {
        int[][] coins = {{0,1,-1},{1,-2,3},{2,-3,4}};
        new lc3418().maximumAmount2(coins);
        System.out.println(new lc3418().maximumAmount(coins));
    }
}
