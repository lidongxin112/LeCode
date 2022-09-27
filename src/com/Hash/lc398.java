
package com.Hash;

import java.util.*;

/**
 * 398. 随机数索引
 * 给你一个可能含有 重复元素 的整数数组 nums ，请你随机输出给定的目标数字 target 的索引。
 * 你可以假设给定的数字一定存在于数组中。
 * Solution(int[] nums) 用数组 nums 初始化对象。
 * int pick(int target) 从 nums 中选出一个满足 nums[i] == target 的随机索引 i
 * 。如果存在多个有效的索引，则每个索引的返回概率应当相等。
 *
 * @author 东鑫
 */
public class lc398 {
    Map<Integer, List<Integer>> map;
    List<Integer> list;

    public lc398(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list1 = map.get(nums[i]);
                list1.add(i);
                map.put(nums[i], list1);
            } else {
                list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
    }

    public int pick(int target) {
        Random r = new Random();
        if (map.containsKey(target)) {
            List<Integer> list = map.get(target);
            int i = r.nextInt(list.size());
            return list.get(i);
        }
        return 0;
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
