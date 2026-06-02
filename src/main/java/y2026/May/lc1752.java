package y2026.May;

/**
 * 1752. 检查数组是否经排序和轮转得到
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
 *
 * 如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
 *
 * 源数组中可能存在 重复项 。
 *
 * 注意：数组 A 在轮转 x 个位置后得到长度相同的数组 B ，使得对于每一个有效的下标 i，满足 B[i] == A[(i+x) % A.length]。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：true
 * 解释：[1,2,3,4,5] 为有序的源数组。
 * 可以轮转 x = 2 个位置，使新数组从值为 3 的元素开始：[3,4,5,1,2] 。
 * 示例 2：
 *
 * 输入：nums = [2,1,3,4]
 * 输出：false
 * 解释：源数组无法经轮转得到 nums 。
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：true
 * 解释：[1,2,3] 为有序的源数组。
 * 可以轮转 x = 0 个位置（即不轮转）得到 nums 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class lc1752 {
    //初始是顺序 改变一个 只会改变一个大于
    public boolean check(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                x++;
            }
        }
        if (nums[nums.length - 1] > nums[0]) {
            x++;
        }
        return x <= 1;
    }
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(new lc1752().check(nums));
        System.out.println(new lc1752().check(new int[]{2,1,3,4}));
    }
}
