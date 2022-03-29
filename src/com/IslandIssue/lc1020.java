package com.IslandIssue;

/**
 * 1020. 飞地的数量
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 * @author 东鑫
 */
public class lc1020 {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 1;
                }
            }
        }


        return res;
    }

    void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;

        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int i = new lc1020().numEnclaves(grid);
        System.out.println(i);
    }
}
