package com.IslandIssue;

/**
 * 1254. 统计封闭岛屿的数目
 * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，
 * 封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 * [[1,1,1,1,1,1,1,0],
 * [1,0,0,0,0,1,1,0],
 * [1,0,1,0,1,1,1,0],
 * [1,0,0,0,0,1,0,1],
 * [1,1,1,1,1,1,1,0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-closed-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 请返回 封闭岛屿 的数目。
 *
 * @author 东鑫
 */
public class lc1254 {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n-1);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;

        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
