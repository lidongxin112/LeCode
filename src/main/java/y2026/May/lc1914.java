package y2026.May;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个大小为 m x n 的整数矩阵 grid​​​ ，其中 m 和 n 都是 偶数 ；另给你一个整数 k 。
 * <p>
 * 矩阵由若干层组成，如下图所示，每种颜色代表一层：
 * <p>
 * <p>
 * <p>
 * 矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 逆时针 方向的相邻元素。轮转示例如下：
 * <p>
 * <p>
 * 返回执行 k 次循环轮转操作后的矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[40,10],[30,20]], k = 1
 * 输出：[[10,20],[40,30]]
 * 解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
 * 输出：[[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
 * 解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 50
 * m 和 n 都是 偶数
 * 1 <= grid[i][j] <= 5000
 * 1 <= k <= 109
 */
public class lc1914 {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ll = Math.min(m, n) / 2;
        for (int i = 0; i < ll; i++) {
            List<Integer> elements = new ArrayList<>();
            int top = i;
            int bottom = m - 1 - i;
            int left = i;
            int right = n - 1 - i;

            //上侧 从左往右
            for (int d = left; d <= right; d++) {
                elements.add(grid[top][d]);
            }
            //右侧从上到下
            for (int c = top+1; c <= bottom; c++) {
                elements.add(grid[c][right]);
            }
            //下侧从右往左
            for (int b = right-1; b >= left; b--) {
                elements.add(grid[bottom][b]);
            }
            //左侧 从下到上
            for (int a = bottom -1 ; a > top; a--) {
                elements.add(grid[a][left]);
            }
            int size = elements.size();
            int rol = k % size;
            int idx = 0;
            for (int d = left; d <= right; d++) {
                grid[top][d] = elements.get((idx + rol) % size);
                idx++;
            }
            for (int c = top+1; c <= bottom; c++) {
                grid[c][right] = elements.get((idx + rol) % size);
                idx++;
            }
            for (int b = right-1; b >= left; b--) {
                grid[bottom][b] = elements.get((idx + rol) % size);
                idx++;
            }
            for (int a = bottom -1 ; a > top; a--) {
                grid[a][top] = elements.get((idx + rol) % size);
                idx++;
            }

        }

        return grid;
    }

    public static void main(String[] args) {
        lc1914 a = new lc1914();
        int[][] aa = new int[][]{
                {40, 10}, {30, 20}
        };
        int[][] ints = a.rotateGrid(aa, 1);
        for (int[] as : ints) {
            System.out.println(as);
        }
    }
}
