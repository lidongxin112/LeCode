package com.shuzu;

import java.util.*;

/**
 * @author 东鑫
 * 373. 查找和最小的 K 对数字
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 */
public class lc373 {
    //优先队列 比较从中拿出数据
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int a = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.add(new int[]{i, 0});
        }// queue 0,0 1,0 2,0
        while (k-- > 0 && !queue.isEmpty()) {
            int[] poll = queue.poll();
            ans.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));
            //
            if (++poll[1] < nums2.length) {
                queue.offer(poll);
                //0 1 0 2
            }
            a++;
        }
        System.out.println(a);
        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 3, 11};
        int[] num2 = {2, 4, 6};

        List<List<Integer>> lists = new lc373().kSmallestPairs(num1, num2, 3);

    }
}
