package simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc552 {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] dp = new int[n + 1][2][3];  //长度，A的数量不能超过2，连续L的数量不能超过3
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            //以P结尾
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }
            //以A结尾
            for (int k = 0; k <= 2; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }
            //以L结尾
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[n][j][k]) %MOD;
            }
        }
        return  sum;
    }
    public int checkRecord1(int n){
        final  int MOD = 1000000007;
        int [][]dp = new int[2][3];
        dp[0][0] = 1;
        for (int i=1;i<=n;i++){
            int [][]dpNew = new int[2][3];
            //以P结尾
            for (int j=0;j<=1;j++){
                for (int k=0;k<=2;k++){
                    dpNew[j][0] = (dpNew[j][0]+dp[j][k]) % MOD;
                }
            }
            //以A结尾
            for (int k = 0; k <= 2; k++) {
                dpNew[1][0] = (dpNew[1][0] + dp[0][k]) % MOD;
            }
            //以L结尾
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                   dpNew[j][k] = (dpNew[j][k] + dp[j][k - 1]) % MOD;
                }
            }
            dp = dpNew;
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[j][k]) %MOD;
            }
        }
        return sum;
        }
    }
