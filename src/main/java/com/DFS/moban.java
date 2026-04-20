package com.DFS;

import java.util.List;
import java.util.Stack;

public class moban {
    //- DFS 适合求“遍历、搜索、回溯、连通性”
    //- DFS：适合“搜到底、找所有、做回溯”
    void dfs(int node, boolean[] visited, List<Integer>[] graph) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, visited, graph);
            }
        }
    }
    void dfs(int start, List<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (visited[cur]) {
                continue;
            }

            visited[cur] = true;

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    stack.push(next);
                }
            }
        }
    }

}
