package com.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class moban {
    // - BFS 适合求“最少、最短、分层”
//      - BFS：适合“按层推、求最短、算步数”
    void bfs(int start, List<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
