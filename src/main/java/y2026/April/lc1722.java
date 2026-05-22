package y2026.April;

import java.util.*;

/**
 * 1722. 执行交换操作后的最小汉明距离
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数数组 source 和 target ，长度都是 n 。还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] = [ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。注意，你可以按 任意 顺序 多次 交换一对特定下标指向的元素。
 *
 * 相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。形式上，其值等于满足 source[i] != target[i] （下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。
 *
 * 在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
 * 输出：1
 * 解释：source 可以按下述方式转换：
 * - 交换下标 0 和 1 指向的元素：source = [2,1,3,4]
 * - 交换下标 2 和 3 指向的元素：source = [2,1,4,3]
 * source 和 target 间的汉明距离是 1 ，二者有 1 处元素不同，在下标 3 。
 * 示例 2：
 *
 * 输入：source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
 * 输出：2
 * 解释：不能对 source 执行交换操作。
 * source 和 target 间的汉明距离是 2 ，二者有 2 处元素不同，在下标 1 和下标 2 。
 * 示例 3：
 *
 * 输入：source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
 * 输出：0
 *
 *
 * 提示：
 *
 * n == source.length == target.length
 * 1 <= n <= 105
 * 1 <= source[i], target[i] <= 105
 * 0 <= allowedSwaps.length <= 105
 * allowedSwaps[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 */
public class lc1722 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] swap : allowedSwaps) {
            union(parent, swap[0], swap[1]);
        }
        Map<Integer, Map<Integer, Integer>> groupCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            groupCount
                    .computeIfAbsent(root, k -> new HashMap<>())
                    .merge(source[i], 1, Integer::sum);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            Map<Integer, Integer> count = groupCount.get(root);
            int value = target[i];

            if (count.getOrDefault(value, 0) > 0) {
                count.put(value, count.get(value) - 1);
            } else {
                ans++;
            }
        }
        return ans;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
    public int minimumHammingDistance1(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        List<Integer>[] g = new ArrayList[n];
//        Arrays.setAll(g, _ -> new ArrayList<>());
        for (int[] e : allowedSwaps) {
            int i = e[0];
            int j = e[1];
            g[i].add(j); // 建图
            g[j].add(i);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int x = 0; x < n; x++) {
            if (!vis[x]) {
                Map<Integer, Integer> diff = new HashMap<>();
                dfs(x, source, target, g, vis, diff);
                for (int c : diff.values()) {
                    ans += Math.abs(c);
                }
            }
        }
        return ans / 2; // 有 ans / 2 对多出来的元素
    }

    private void dfs(int x, int[] source, int[] target, List<Integer>[] g, boolean[] vis, Map<Integer, Integer> diff) {
        vis[x] = true; // 避免重复访问
        // 抵消相同的元素，最终剩下 source 和 target 各自多出来的元素（对称差）
        diff.merge(source[x], 1, Integer::sum);  // diff[source[x]]++;
        diff.merge(target[x], -1, Integer::sum); // diff[target[x]]--;
        for (int y : g[x]) {
            if (!vis[y]) {
                dfs(y, source, target, g, vis, diff);
            }
        }
    }

    public static void main(String[] args) {
        int[] source = {5,1,2,4,3};
        int[] target = {1,5,4,2,3};
        int[][] allowedSwaps = {{0,4},{4,2},{1,3},{1,4}};
        lc1722 lc1722 = new lc1722();
//        int i = lc1722.minimumHammingDistance(source, target, allowedSwaps);
//        System.out.println(i);
        System.out.println(lc1722.minimumHammingDistance(new int[]{1,2,3,4}, new int[]{2,1,4,5}, new int[][]{{0,1},{2,3}}));
    }

}
