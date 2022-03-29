package com.DFS;

/**
 * @author 东鑫
 * @date 2021/12/07 20:33
 * <p>
 * 1034. 边界着色
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。
 * 网格中的每个值表示该位置处的网格块的颜色。
 * <p>
 * 两个网格块属于同一 连通分量 需满足下述全部条件：
 * <p>
 * 两个网格块颜色相同
 * 在上、下、左、右任意一个方向上相邻
 * 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 * <p>
 * 在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
 * 在网格的边界上（第一行/列或最后一行/列）
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，
 * 并返回最终的网格 grid 。
 */
public class lc1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (grid[row][col] == color) {
            return grid;
        }
        int pre = grid[row][col];

        int[][] mask = new int[grid.length][grid[0].length];

        dfs(grid, row, col, pre, color, mask);
        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid[0].length-1; j++) {
                if (mask[i][j] == 1 && mask[i - 1][j] == 1 && mask[i + 1][j] == 1 && mask[i][j + 1] == 1 && mask
                        [i][j - 1] == 1) {
                    grid[i][j] = pre;
                }
            }
        }
        return grid;
    }

    public void dfs(int[][] grid, int x, int y, int pre, int color, int[][] mask) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != pre) {
            return;
        }
        grid[x][y] = color;
        mask[x][y] = 1;
        dfs(grid, x -1,  y, pre, color, mask);
        dfs(grid, x +1,  y, pre, color, mask);
        dfs(grid, x, y - 1, pre, color, mask);
        dfs(grid, x, y + 1, pre, color, mask);
    }

    public static void main(String[] args) {
        int [][] grid =  {{1,1},{1,2}};
        int[][] ints = new lc1034().colorBorder(grid, 0, 0, 3);
    }
}
