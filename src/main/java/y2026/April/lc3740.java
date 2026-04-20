package y2026.April;

import java.util.*;

/**
 * 3740. 三个相等元素之间的最小距离 I
 * 如果满足 nums[i] == nums[j] == nums[k]，且 (i, j, k) 是 3 个 不同 下标，那么三元组 (i, j, k) 被称为 有效三元组 。
 * 有效三元组 的 距离 被定义为 abs(i - j) + abs(j - k) + abs(k - i)，其中 abs(x) 表示 x 的 绝对值 。
 * 返回一个整数，表示 有效三元组 的 最小 可能距离。如果不存在 有效三元组 ，返回 -1。
 * 输入： nums = [1,2,1,1,3]
 * 输出： 6
 * 最小距离对应的有效三元组是 (0, 2, 3) 。
 * (0, 2, 3) 是一个有效三元组，因为 nums[0] == nums[2] == nums[3] == 1。它的距离为 abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6。
 *
 * 示例 2：
 *
 * 输入： nums = [1,1,2,3,2,1,2]
 *
 * 输出： 8
 *
 * 解释：
 *
 * 最小距离对应的有效三元组是 (2, 4, 6) 。
 *
 * (2, 4, 6) 是一个有效三元组，因为 nums[2] == nums[4] == nums[6] == 2。它的距离为 abs(2 - 4) + abs(4 - 6) + abs(6 - 2) = 2 + 2 + 4 = 8。
 *
 * 示例 3：
 *
 * 输入： nums = [1]
 *
 * 输出： -1
 *
 * 解释：
 *
 * 不存在有效三元组，因此答案为 -1。
 *
 *
 *
 * 提示：
 *
 * 1 <= n == nums.length <= 100
 * 1 <= nums[i] <= n
 */
public class lc3740 {

    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int res = Integer.MAX_VALUE;
        for (Integer a : map.keySet()) {
            if (map.get(a).size() >= 3) {
                for (int i = 0; i < map.get(a).size() - 2; i++) {
                    res = Math.min(res, map.get(a).get(i + 2) - map.get(a).get(i));
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : 2 * res;
    }
    public int minimumDistance2(int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] != nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] == nums[k]) {
                        ans = Math.min(ans, k - i);
                        break;
                    }
                }
            }
        }

        return ans == n + 1 ? -1 : ans * 2;
    }
    public int minimumDistance3(int[] nums) {
        int n = nums.length;
        int[] last = new int[n+1];
        int[] old = new int[n+1];
        Arrays.fill(last ,-n-1);
        Arrays.fill(old,-n-1);
        int ans = n+1;
        for(int i = 0;i<n;i++){
            int x = nums[i];
            ans = Math.min(ans,(i-old[x]));
            old[x] = last[x];
            last[x] = i;
        }
        return ans == n + 1 ? -1 : ans * 2;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,1,3};
        System.out.println(new lc3740().minimumDistance(nums));
        System.out.println(new lc3740().minimumDistance3(nums));

    }
}
