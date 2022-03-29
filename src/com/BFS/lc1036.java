package com.BFS;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author 东鑫
 * 1036. 逃离大迷宫
 * 在一个 106 x 106 的网格中，每个网格上方格的坐标为 (x, y) 。
 * 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。
 * 数组 blocked 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。
 * 同时，不允许走出网格。
 * 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。
 * 否则，返回 false。
 */
public class lc1036 {
    static final int[][] way = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        return bfs(blocked, source, target);
    }

    public boolean bfs(int[][] blocked, int[] source, int[] target) {
        Set<Integer> set = new HashSet<>();
        for (int[] b : blocked) {
            set.add(1000000 * b[0] + b[1]);
        }
        set.add(1000000 * source[0] + source[1]);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size >= blocked.length) {
                return true;
            }
            while (--size >= 0) {
                int[] p = queue.poll();
                for (int[] d : way) {
                    int x = p[0] + d[0], y = p[1] + d[1];
                    if (x < 0 || x >= 1000000 || y < 0 || y >= 1000000) {
                        continue;
                    }
                    if (x == target[0] && y == target[1]) {
                        return true;
                    }
                    if (set.add(1000000 * x + y)) {
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] aa = {{0,1},{1,0}};
        int [] s = {0,0};
        int [] t= {0,2};
        boolean escapePossible = new lc1036().isEscapePossible(aa, s, t);
    }
}
