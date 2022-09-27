package com.dynamicProgramming;

/**
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * <p>
 * 我从1到 n 之间选择一个数字。
 * 你来猜我选了哪个数字。
 * 如果你猜到正确的数字，就会 赢得游戏 。
 * 如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
 * 每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
 * 给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。
 *
 * 状态方程：f(i,j) = 统计(1,n)min(k + max(f(i,x-1),f(x+1,n))
 */
public class lc375 {
    /**public int getMoneyAmount(int n) {
     if (n==1){
     return 0;
     }
     int [][] num = new int[n+1][n+1];
     for (int i=n-1;i>=1;i--){
     for (int j = i+1;j<=n;j++){
     int minCost = Integer.MAX_VALUE;
     for (int k=i;k<j;k++){
     int cost = k + Math.max(num[i][k-1],num[k+1][j]);
     minCost = Math.min(cost,minCost);
     }
     num[i][j] = minCost;
     }
     }
     return num[1][n];
     }
     **/
    /**
     * @param args
     */
    static int N = 210;
    static int[][] cache = new int[N][N];

    public int getMoneyAmount(int n) {
        return dfs(1, n);
    }
    public int dfs(int l, int r) {
        if (l >= r) {
            return 0;
        }
        if (cache[l][r] != 0) {
            return cache[l][r];
        }
        int ans = 0x3f3f3f3f;
        for (int x = l; x <= r; x++) {
            // 当选择的数位 x 时，至少需要 cur 才能猜中数字
            int cur = Math.max(dfs(l, x - 1), dfs(x + 1, r)) + x;
            // 在所有我们可以决策的数值之间取最优
            ans = Math.min(ans, cur);
        }
        cache[l][r] = ans;
        return ans;
    }


    public static void main(String[] args) {
        int moneyAmount = new lc375().getMoneyAmount(10);
        System.out.println(moneyAmount);
    }
}
