package y2026.April;

import java.util.*;

/**
 * 1971. 寻找图中是否存在路径
 * 有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
 * 请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。
 * 给你数组 edges 和整数 n、source 和 destination，如果从 source 到 destination 存在 有效路径 ，则返回 true，否则返回 false 。
 * 输入：n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * 输出：true
 * 解释：存在由顶点 0 到顶点 2 的路径:
 * - 0 → 1 → 2
 * - 0 → 2
 * 输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * 输出：false
 * 解释：不存在由顶点 0 到顶点 5 的路径.
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= source, destination <= n - 1
 * 不存在重复边
 * 不存在指向顶点自身的边
 */
public class lc1971 {
    Map<Integer,Integer> map = new HashMap<>();
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges == null || edges.length == 0){
            return true;
        }
        if (n==1){
            return false;
        }
        for (int[] edge : edges){
            union(edge[0],edge[1]);
        }
        if (find(source) == find(destination)){
            return true;
        }
        return false;
    }
    int find(int a){
        if (!map.containsKey(a)){
            map.put(a,a);
        }
        if (map.get(a) != a){
            map.put(a,find(map.get(a)));
        }
        return map.get(a);
    }
    void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if (fa != fb){
            map.put(fa,fb);
        }
    }
    //广度优先搜索 BFS
    public boolean validPath1(int n, int[][] edges, int source, int destination) {
        List<Integer>[] list = new List[n];
        for (int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        boolean [] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            if (cur == destination){
                break;
            }
            for (int next : list[cur]){
                if (!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return visited[destination];
    }
    //深度优先搜索 DFS
        public boolean validPath2(int n, int[][] edges, int source, int destination) {
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<Integer>();
            }
            for (int[] edge : edges) {
                int x = edge[0], y = edge[1];
                adj[x].add(y);
                adj[y].add(x);
            }
            boolean[] visited = new boolean[n];
            return dfs(source, destination, adj, visited);
        }

        public boolean dfs(int source, int destination, List<Integer>[] adj, boolean[] visited) {
            if (source == destination) {
                return true;
            }
            visited[source] = true;
            for (int next : adj[source]) {
                if (!visited[next] && dfs(next, destination, adj, visited)) {
                    return true;
                }
            }
            return false;
        }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};


        System.out.println(new lc1971().validPath(6, edges, 0, 5));
    }
}
