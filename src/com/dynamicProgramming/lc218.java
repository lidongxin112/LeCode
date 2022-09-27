package com.dynamicProgramming;

import java.util.*;

/**
 * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 * lefti 是第 i 座建筑物左边缘的 x 坐标。
 * righti 是第 i 座建筑物右边缘的 x 坐标。
 * heighti 是第 i 座建筑物的高度。
 * 你可以假设所有的建筑都是完美的长方形，在高度为 0的绝对平坦的表面上。
 * 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。
 * 关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，
 * 任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...]
 * 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 *
 *
 * ps:优先队列用来求取当前的最大高度
 * @author 东鑫
 */
public class lc218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> pg = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        List<Integer> boun = new ArrayList<>();
        for (int[] build : buildings) {
            boun.add(build[0]);
            boun.add(build[1]);
        }
        Collections.sort(boun);
        List<List<Integer>> ret = new ArrayList<>();
        int n = buildings.length, idx = 0;
        for (int bou : boun) {
            while (idx < n && buildings[idx][0] <= bou) {
                pg.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            while (!pg.isEmpty() && pg.peek()[0] <= bou) {
                pg.poll();
            }
            int maxn = pg.isEmpty() ? 0 : pg.peek()[1];
            if (ret.size() == 0 || maxn != ret.get(ret.size() - 1).get(1)) {
                ret.add(Arrays.asList(bou, maxn));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] av = {{2, 9, 10},
                      {3, 7, 5},
                      {5, 12, 12},
                      {15, 20, 10},
                      {19, 24, 8}};
        List<List<Integer>> skyline = new lc218().getSkyline(av);
    }
}
