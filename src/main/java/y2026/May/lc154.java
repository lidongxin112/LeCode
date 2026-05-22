package y2026.May;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须尽可能减少整个过程的操作步骤。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,5]
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 *
 * 进阶：这道题与 寻找旋转排序数组中的最小值 类似，但 nums 可能包含重复元素。允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 */
public class lc154 {
    public int findMin1(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        nums = set.stream().mapToInt(Integer::intValue).toArray();
        if (nums.length == 1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[left + 1] && nums[left] < nums[right]){
            return nums[left];
        }
        if (nums[right] < nums[right - 1] && nums[right] < nums[left]){
            return nums[right];
        }
        while (left < right){
            int mid = (right + left) / 2;
            if (nums[left] < nums[mid]){
                left++;
                continue;
            }else{
                right--;
            }
            if (nums[mid] > nums[right]){
                right--;
                continue;
            }

            if (nums[mid] < nums[0] && nums[mid] < nums[mid+1] &&  nums[mid] < nums[mid-1] && nums[mid] < nums[nums.length - 1]){
                return nums[mid];
            }
        }
        return nums[(right + left) / 2];
    }
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }


    public static void main(String[] args) {
        int[] nums = {1,3,5};
        System.out.println(new lc154().findMin(nums));
        nums = new int[]{2,2,2,0,1};
        System.out.println(new lc154().findMin(nums));
        nums = new int[]{3,4,4,4,4,4,4,5,5,6,6,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,10,10,10,-10,-10,-10,-9,-8,-8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-3,-3,-3,-3,-2,-2,-2,-2,-1,-1,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3};
        System.out.println(new lc154().findMin(nums));
        float a = 3.142f;
        System.out.println(a);
    }

}
