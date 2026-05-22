package y2026.May;

import java.util.*;

/**
 * 1345. 跳跃游戏 IV
 * 已解答
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 *
 * 每一步，你可以从下标 i 跳到下标 i + 1 、i - 1 或者 j ：
 *
 * i + 1 需满足：i + 1 < arr.length
 * i - 1 需满足：i - 1 >= 0
 * j 需满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 *
 * 注意：任何时候你都不能跳到数组外面。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * 示例 2：
 *
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * 示例 3：
 *
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 5 * 104
 * -108 <= arr[i] <= 108
 */
public class lc1345 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int step =  steps[cur];
            if (cur == n - 1){
                return step;
            }
            if (cur + 1 < n && steps[cur + 1] == Integer.MAX_VALUE) {
                steps[cur + 1] = step + 1;
                queue.add(cur + 1);
            }
            if (cur - 1 >= 0 && steps[cur - 1] == Integer.MAX_VALUE) {
                steps[cur - 1] = step + 1;
                queue.add(cur - 1);
            }
            List<Integer> nextList = map.getOrDefault(arr[cur],new ArrayList<>());
            for (Integer next : nextList) {
                if (steps[next] == Integer.MAX_VALUE) {
                    steps[next] = step + 1;
                    queue.add(next);
                }
            }
            map.remove(arr[cur]);
        }
        return 0;
    }
    public int minJumps1(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        boolean [] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == n - 1) {
                    return step;
                }
                if (cur + 1 < n && !visited[cur + 1]) {
                    visited[cur + 1] = true;
                    queue.offer(cur + 1);
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    visited[cur - 1] = true;
                    queue.offer(cur - 1);
                }
                List<Integer> nextList = map.getOrDefault(arr[cur], new ArrayList<>());
                for (Integer next : nextList) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
                map.remove(arr[cur]);
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(new lc1345().minJumps(arr));
        System.out.println(new lc1345().minJumps1(arr));


    }
}
