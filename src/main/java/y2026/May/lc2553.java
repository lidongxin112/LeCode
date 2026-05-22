package y2026.May;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个正整数数组 nums ，请你返回一个数组 answer ，你需要将 nums 中每个整数进行数位分割后，按照 nums 中出现的 相同顺序 放入答案数组中。
 *
 * 对一个整数进行数位分割，指的是将整数各个数位按原本出现的顺序排列成数组。
 *
 * 比方说，整数 10921 ，分割它的各个数位得到 [1,0,9,2,1] 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [13,25,83,77]
 * 输出：[1,3,2,5,8,3,7,7]
 * 解释：
 * - 分割 13 得到 [1,3] 。
 * - 分割 25 得到 [2,5] 。
 * - 分割 83 得到 [8,3] 。
 * - 分割 77 得到 [7,7] 。
 * answer = [1,3,2,5,8,3,7,7] 。answer 中的数字分割结果按照原数字在数组中的相同顺序排列。
 * 示例 2：
 *
 * 输入：nums = [7,1,3,9]
 * 输出：[7,1,3,9]
 * 解释：nums 中每个整数的分割是它自己。
 * answer = [7,1,3,9] 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 105
 */
public class lc2553 {

    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int num : nums){
            if (num < 10){
                list.add(num);
            }
            else {
                while (num > 0){
                    sb.append(num % 10);
                    num = num / 10;
                }
                sb = sb.reverse();
                for (int i = 0; i < sb.length(); i++){
                    list.add(Integer.parseInt(sb.charAt(i) + ""));
                }
                sb = new StringBuilder();
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {13,25,83,77};
        int[] separateDigits = new lc2553().separateDigits(nums);
        for (int i : separateDigits) {
            System.out.print(i + " ");
        }
    }
}
