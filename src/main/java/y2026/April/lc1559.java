package y2026.April;

/**
 * 给你一个二维字符网格数组 grid ，大小为 m x n ，你需要检查 grid 中是否存在 相同值 形成的环。
 *
 * 一个环是一条开始和结束于同一个格子的长度 大于等于 4 的路径。对于一个给定的格子，你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这两个格子有 相同的值 。
 *
 * 同时，你也不能回到上一次移动时所在的格子。比方说，环  (1, 1) -> (1, 2) -> (1, 1) 是不合法的，因为从 (1, 2) 移动到 (1, 1) 回到了上一次移动时的格子。
 *
 * 如果 grid 中有相同值形成的环，请你返回 true ，否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
 * 输出：true
 * 解释：如下图所示，有 2 个用不同颜色标出来的环：
 *
 * 示例 2：
 *
 *
 *
 * 输入：grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
 * 输出：true
 * 解释：如下图所示，只有高亮所示的一个合法环：
 *
 * 示例 3：
 *
 *
 *
 * 输入：grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
 * 输出：false
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 500
 * 1 <= n <= 500
 * grid 只包含小写英文字母
 */
public class lc1559 {
    private int m;
    private int n;
    private boolean[][] visit;
    private char[][] grid;
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];
        this.grid = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]){
                    if (dfs(i, j, -1, -1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(int x,int y,int px,int py){
        visit[x][y] = true;
        for (int[] dir : dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n ){
                continue;
            }
            if (grid[nx][ny] != grid[x][y]){
                continue;
            }
            if (nx == px && ny == py){
                continue;
            }
            if (visit[nx][ny]){
                return true;
            }
            if (dfs(nx,ny,x,y)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] grid = {{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
        System.out.println(new lc1559().containsCycle(grid));
    }
}
