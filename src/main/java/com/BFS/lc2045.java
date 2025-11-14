package com.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author 东鑫
 * 2045. 到达目的地的第二短时间
 * 城市用一个 双向连通 图表示，图中有 n 个节点，从 1 到 n 编号（包含 1 和 n）。
 * 图中的边用一个二维整数数组 edges 表示，
 * 其中每个 edges[i] = [ui, vi] 表示一条节点 ui 和节点 vi 之间的双向连通边。
 * 每组节点对由 最多一条 边连通，顶点不存在连接到自身的边。穿过任意一条边的时间是 time 分钟。
 * 每个节点都有一个交通信号灯，每 change 分钟改变一次，从绿色变成红色，再由红色变成绿色，
 * 循环往复。所有信号灯都 同时 改变。你可以在 任何时候 进入某个节点
 * ，但是能在节点信号灯是绿色时 才能离开。如果信号灯是  绿色 ，你 不能 在节点等待，必须离开。
 * 第二小的值 是 严格大于 最小值的所有值中最小的值。
 * 例如，[2, 3, 4] 中第二小的值是 3 ，而 [2, 2, 4] 中第二小的值是 4 。
 * 给你 n、edges、time 和 change ，返回从节点 1 到节点 n 需要的 第二短时间 。
 */
public class lc2045 {
    static int N = 10010, M = 4 * N, INF = 0x3f3f3f3f, idx = 0;
    static int[] he = new int[N], e = new int[M], ne = new int[M];

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        idx++;
    }
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Arrays.fill(he, -1);
        idx = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            add(u, v);
            add(v, u);
        }
        Deque<int[]> d = new ArrayDeque<>();
        int[] dist1 = new int[n + 10], dist2 = new int[n + 10];
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        d.addLast(new int[]{1, 0});
        dist1[1] = 0;
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int u = poll[0], dist = poll[1];
            for (int i = he[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist1[j] > dist + 1) {
                    dist2[j] = dist1[j];
                    dist1[j] = dist + 1;
                    d.addLast(new int[]{j, dist1[j]});
                    d.addLast(new int[]{j, dist2[j]});
                } else if (dist1[j] < dist + 1 && dist + 1 < dist2[j]) {
                    dist2[j] = dist + 1;
                    d.addLast(new int[]{j, dist2[j]});
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < dist2[n]; i++) {
            int a = ans / change, b = ans % change;
            int wait = a % 2 == 0 ? 0 : change-b;
            ans += time + wait;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][]a ={{1,2},{1,3},{1,4},{3,4},{4,5}};

        int i = new lc2045().secondMinimum(5, a, 3, 5);
        System.out.println(i);
    }
}
