package y2026.April;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 示例 3：
 *
 * 输入：nums = [1,0,1,2]
 * 输出：3
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class lc128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums){
            set.add(i);
        }
        int sum = 0;
        for (int i:nums){
            if (set.contains(i-1)){
                continue;
            }
            int count = 0;
            int j = i;
            while (set.contains(j)){
                j+=1;
                count++;
            }
            sum = Math.max(count,sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
//        nums = new int[]{0,3,7,2,5,8,4,6,0,1};
//        nums = new int[]{1,0,1,2};
        System.out.println(new lc128().longestConsecutive(nums));
    }
}
