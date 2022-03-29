package simple;

public class lc576 {
    // m 行 n 列   maxMove 移动次数 startRow 横坐标 start、Column 纵坐标  为球的位置
    //返回结果为路径条数
    //三层for 时间复杂度为O(nnn)
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1000000007;
        int[][] ss = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int nums = 0;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        for (int i = 0; i < maxMove; i++) {
            int[][] dpNew = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int count = dp[j][k];
                    if (count > 0) {
                        for (int[] ssa : ss) {
                            int j1 = j + ssa[0], k1 = k + ssa[1];
                            if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                                dpNew[j1][k1] = (dpNew[j1][k1] + count) % MOD;
                            } else {
                                nums = (nums + count) % MOD;
                            }
                        }
                    }
                }
            }
            dp = dpNew;
        }
        return nums;
    }

    public static void main(String[] args) {
        new lc576().findPaths(2, 2, 2, 0, 0);
    }
}
