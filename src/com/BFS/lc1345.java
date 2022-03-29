package com.BFS;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @author 东鑫
 * 1345. 跳跃游戏 IV
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * 每一步，你可以从下标 i 跳到下标：
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * 注意：任何时候你都不能跳到数组外面。
 */
public class lc1345 {
        int INF = 0x3f3f3f3f;
        public int minJumps(int[] arr) {
            int n = arr.length;
            Map<Integer, List<Integer>> map = new HashMap<>();
            // 倒序插入 list，相当于给 deque 增加一个同层「下标越大，优先出队」的作用
            for (int i = n - 1; i >= 0; i--) {
                List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
                list.add(i);
                map.put(arr[i], list);
            }
            int[] dist = new int[n];
            Arrays.fill(dist, INF);
            Deque<Integer> d = new ArrayDeque<>();
            d.addLast(0);
            dist[0] = 0;
            while (!d.isEmpty()) {
                int t = d.pollFirst(), step = dist[t];
                if (t == n - 1) return step;
                if (t + 1 < n && dist[t + 1] == INF) {
                    d.addLast(t + 1);
                    dist[t + 1] = step + 1;
                }
                if (t - 1 >= 0 && dist[t - 1] == INF) {
                    d.addLast(t - 1);
                    dist[t - 1] = step + 1;
                }
                List<Integer> list = map.getOrDefault(arr[t], new ArrayList<>());
                for (int ne : list) {
                    if (dist[ne] == INF) {
                        d.addLast(ne);
                        dist[ne] = step + 1;
                    }
                }
                map.remove(arr[t]);
            }
            return -1; // never
        }

    public int bfs(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int aar = arr.length;
        int step = 0;
        q.offer(arr[0]);
        set.add(arr[0]);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Integer poll = q.poll();
                if (poll == arr[aar - 1]) {
                    return step;
                }

            }

        }


        return step;
    }
}
