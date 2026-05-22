package y2026.May;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class lc239 {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[] a = new int[n-k + 1];
        if (n <= k){
            for (int num: nums){
                max = Math.max(num,max);
            }
            a[0] = max;
            return a;
        }
        for (int i = 0; i <= n - k; i++) {
            max = Integer.MIN_VALUE;
            for (int j = i; j < n && j <= i + k - 1; j++){
                max = Math.max(nums[j],max);
            }
            a[i] = max;

        }
        return a;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> a = new ArrayDeque<>();
        int n = nums.length;
        a.offer(nums[0]);
        for (int i = 1; i < k; i++) {
            while (!a.isEmpty() && a.peekLast() < nums[i]){
                a.pollLast();
            }
            a.offer(nums[i]);
        }
        int[] b = new int[n-k + 1];
        b[0] = a.peek();
        for (int i = 1; i <= n - k; i++) {
            if (a.peek() == nums[i-1]){
                a.poll();
            }
            while (!a.isEmpty() && a.peekLast() < nums[i+k-1]){
                a.pollLast();
            }
            a.offer(nums[i+k-1]);
            b[i] = a.peek();
        }
        return b;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = new lc239().maxSlidingWindow(nums1, k);
        for (int a:ints){
            System.out.println(a);
        }

    }
}


