package y2026.May;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1674. 使数组互补的最少操作次数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 偶数 n 的整数数组 nums 和一个整数 limit 。每一次操作，你可以将 nums 中的任何整数替换为 1 到 limit 之间的另一个整数。
 *
 * 如果对于所有下标 i（下标从 0 开始），nums[i] + nums[n - 1 - i] 都等于同一个数，则数组 nums 是 互补的 。例如，数组 [1,2,3,4] 是互补的，因为对于所有下标 i ，nums[i] + nums[n - 1 - i] = 5 。
 *
 * 返回使数组 互补 的 最少 操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,4,3], limit = 4
 * 输出：1
 * 解释：经过 1 次操作，你可以将数组 nums 变成 [1,2,2,3]（加粗元素是变更的数字）：
 * nums[0] + nums[3] = 1 + 3 = 4.
 * nums[1] + nums[2] = 2 + 2 = 4.
 * nums[2] + nums[1] = 2 + 2 = 4.
 * nums[3] + nums[0] = 3 + 1 = 4.
 * 对于每个 i ，nums[i] + nums[n-1-i] = 4 ，所以 nums 是互补的。
 * 示例 2：
 *
 * 输入：nums = [1,2,2,1], limit = 2
 * 输出：2
 * 解释：经过 2 次操作，你可以将数组 nums 变成 [2,2,2,2] 。你不能将任何数字变更为 3 ，因为 3 > limit 。
 * 示例 3：
 *
 * 输入：nums = [1,2,1,2], limit = 2
 * 输出：0
 * 解释：nums 已经是互补的。
 *
 *
 * 提示：
 *
 * n == nums.length
 * 2 <= n <= 105
 * 1 <= nums[i] <= limit <= 105
 * n 是偶数。
 */
public class lc1674 {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] dp = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i] + nums[n - 1 - i];
            dp[i] = a;
        }
        Arrays.sort(dp);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n / 2; i++) {
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }
        if (dp[0] < limit){
            map.put(limit, 1);
        }
        int ans = Integer.MAX_VALUE;
        for (Integer a :map.keySet()){
            int sum = 0;
            for (int i = 0; i < n / 2; i++) {
                if (nums[i] + nums[n - 1 - i] == a){
                    continue;
                }else {
                    if (nums[i] + nums[n - 1 - i] > a){
                        if (1 + nums[n - 1 - i] <= a && limit + nums[n - 1 - i] >= a) {
                            sum++;
                            continue;
                        }
                        if (1 + nums[i] <= a && limit + nums[i] >= a) {
                            sum++;
                            continue;
                        }
                        if (2 <=a  && 2 * limit >= a){
                            sum+=2;
                            continue;
                        }else {
                            sum = Integer.MAX_VALUE;
                            break;
                        }

                    }
                    if (nums[i] + nums[n - 1 - i] < a){
                        if (1 + nums[n - 1 - i] < a && limit + nums[n - 1 - i] >= a) {
                            sum++;
                            continue;
                        }
                        if (1 + nums[i] < a && limit + nums[i] >= a) {
                            sum++;
                            continue;
                        }
                        if (2 <=a  && 2 * limit >= a){
                            sum+=2;
                        }else {
                            sum = Integer.MAX_VALUE;
                            break;
                        }
                    }
                }
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }

    public int minMovesOptimized(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            int sum = a + b;

            // 每个数对默认需要 2 次；[low, high] 只需 1 次；sum 这个点需要 0 次。
            diff[2] += 2;
            diff[low] -= 1;
            diff[sum] -= 1;
            diff[sum + 1] += 1;
            diff[high + 1] += 1;
        }

        int ans = n;
        int moves = 0;
        for (int target = 2; target <= 2 * limit; target++) {
            moves += diff[target];
            ans = Math.min(ans, moves);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,3};
        int limit = 4;
        System.out.println(new lc1674().minMoves(nums,limit));
        System.out.println(new lc1674().minMoves(new int[]{1,2,2,1},2));
        System.out.println(new lc1674().minMoves(new int[]{1,2,1,2},2));
        System.out.println(new lc1674().minMoves(new int[]{1,2,3,4},4));
        System.out.println(new lc1674().minMoves(new int[]{37,2,9,49,58,57,48,17},58));
        System.out.println(new lc1674().minMoves(new int[]{20744,7642,19090,9992,2457,16848,3458,15721},22891));

    }
}
