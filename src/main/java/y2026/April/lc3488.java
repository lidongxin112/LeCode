package y2026.April;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 3488. 距离最小相等元素查询
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 环形 数组 nums 和一个数组 queries 。
 * <p>
 * 对于每个查询 i ，你需要找到以下内容：
 * <p>
 * 数组 nums 中下标 queries[i] 处的元素与 任意 其他下标 j（满足 nums[j] == nums[queries[i]]）之间的 最小 距离。如果不存在这样的下标 j，则该查询的结果为 -1 。
 * 返回一个数组 answer，其大小与 queries 相同，其中 answer[i] 表示查询i的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,3,1,4,1,3,2], queries = [0,3,5]
 * <p>
 * 输出： [2,-1,3]
 * <p>
 * 解释：
 * <p>
 * 查询 0：下标 queries[0] = 0 处的元素为 nums[0] = 1 。最近的相同值下标为 2，距离为 2。
 * 查询 1：下标 queries[1] = 3 处的元素为 nums[3] = 4 。不存在其他包含值 4 的下标，因此结果为 -1。
 * 查询 2：下标 queries[2] = 5 处的元素为 nums[5] = 3 。最近的相同值下标为 1，距离为 3（沿着循环路径：5 -> 6 -> 0 -> 1）。
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,3,4], queries = [0,1,2,3]
 * <p>
 * 输出： [-1,-1,-1,-1]
 * <p>
 * 解释：
 * <p>
 * 数组 nums 中的每个值都是唯一的，因此没有下标与查询的元素值相同。所有查询的结果均为 -1。
 */
public class lc3488 {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> ans = new ArrayList<Integer>();
        int n = queries.length;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<Integer>()).add(i);
        }
        for (int i = 0; i < n; i++) {
            int res = Integer.MAX_VALUE;
            if (map.get(nums[queries[i]]).size() == 1) {
                res = -1;
            } else {
                //todo 二分查找 只看前后位置就行了 无效for timeout

                for (int j = 0; j < map.get(nums[queries[i]]).size(); j++) {
                    if (queries[i] == map.get(nums[queries[i]]).get(j)) {
                        continue;
                    }
                    res = Math.min(res, Math.min(Math.abs(map.get(nums[queries[i]]).get(j) - queries[i]), nums.length - Math.abs(map.get(nums[queries[i]]).get(j) - queries[i])));
                }
            }
        }
        return ans;
    }
    public List<Integer> solveQueries2(int[] nums, int[] queries) {
        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> numsPos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numsPos.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (ArrayList<Integer> pos : numsPos.values()) {
            int x = pos.get(0);
            int last = pos.get(pos.size() - 1);
            pos.add(0, last - n);
            pos.add(x + n);
        }
        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            int x = nums[q];
            ArrayList<Integer> posList = numsPos.get(x);

            if (posList.size() == 3) {
                result.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(posList, q);
            if (idx < 0) idx = -idx - 1;

            int dist = Math.min(posList.get(idx + 1) - posList.get(idx),
                    posList.get(idx) - posList.get(idx - 1));
            result.add(dist);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 4, 1, 3, 2};
        int[] queries = {0, 3, 5};
        lc3488 lc3488 = new lc3488();
        List<Integer> solveQueries = lc3488.solveQueries(nums, queries);
        solveQueries.forEach(System.out::println);
        int[] nums1 = {15,1,10,1,20,4,6,14,4,9,4,18};
        int[] queries1 = {0,2,10,6,11,8};
        List<Integer> solveQueries1 = lc3488.solveQueries(nums1, queries1);
        lc3488.solveQueries2(nums1,queries1);
        solveQueries1.forEach(System.out::println);
    }
}
