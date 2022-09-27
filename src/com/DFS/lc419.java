package com.DFS;

/**
 * @author 东鑫
 * 419. 甲板上的战舰
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，
 * 返回在甲板 board 上放置的 战舰 的数量。
 * <p>
 * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，
 * 其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 */
public class lc419 {
    private boolean[][] visit;
    private int cnt = 0;

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if ((i > 0 && board[i - 1][j] == 'X') || (j > 0 && board[i][j - 1] == 'X')) {
                        continue;
                    }
                    ans++;
                }
            }
        }
//        visit = new boolean[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (!visit[i][j] && board[i][j] == 'X') {
//                    dfs(board, i, j);
//                    cnt++;
//                }
//            }
//        }

        return ans;
//        return cnt;
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            visit[i][j] = false;
        }
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

    public static void main(String[] args) {
        char [][] aa= {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        int i = new lc419().countBattleships(aa);
        System.out.println(i);
    }
}
