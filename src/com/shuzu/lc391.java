package com.shuzu;

/**
 * 391. 完美矩形
 * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。
 * 这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
 * <p>
 * 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
 */
public class lc391 {
    public boolean isRectangleCover(int[][] rectangles) {
        int sum = 0;
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        for (int[] b : rectangles) {
            int x = b[2] - b[0];
            int y = b[3] - b[1];
            x1 = Math.min(b[0], x1);
            x2 = Math.max(b[2], x2);
            y1 = Math.min(b[1], y1);
            y2 = Math.max(b[3], y2);
            sum += x * y;
        }

        int c = (x2 - x1) * (y2 - y1);

        return sum == c ? true : false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        int[][] b = {{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {2, 2, 4, 4}};
        boolean rectangleCover = new lc391().isRectangleCover(b);
        System.out.println(rectangleCover);
    }
}
