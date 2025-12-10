package reactInterview;

public class day5 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     * 子数组是数组中元素的连续非空序列。
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     Will Brute force work here? Try to optimize it.
     Can we optimize it by using some extra space?
     What about storing sum frequencies in a hash table? Will it be useful?
     sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1. Can we use this property to optimize it.
     */
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        for (int i = 0;i<nums.length;i++){
            int temp = k - nums[i];
            if (temp == 0){
                sum++;
            }
            for (int j = i+1;j<nums.length;j++){
                temp = temp - nums[j];
                if (temp == 0){
                    sum++;
                }
            }
        }
        return sum;
    }
    public int subarraySum1(int[] nums, int k) {
        int[][] sums = new int[nums.length][nums.length];
        int sum = 0;
        for (int i = 0;i< nums.length;i++){
            sums[i][i] = nums[i];
            for (int j = i+1;j<nums.length;j++){
                sums[i][j] = sums[i][j-1] + nums[j];
                if (sums[i][j] == k){
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new day5().subarraySum(new int[]{1,1,1},2));
        System.out.println(new day5().subarraySum(new int[]{1,2,3},3));
        System.out.println(new day5().subarraySum(new int[]{1,-1,0},0));
        System.out.println(new day5().subarraySum(new int[]{0,0},0));
        System.out.println(new day5().subarraySum(new int[]{28,54,7,-70,22,65,-6},100));

        System.out.println(new day5().subarraySum1(new int[]{1,1,1},2));
        System.out.println(new day5().subarraySum1(new int[]{1,2,3},3));
        System.out.println(new day5().subarraySum1(new int[]{1,-1,0},0));
        System.out.println(new day5().subarraySum1(new int[]{0,0},0));
        System.out.println(new day5().subarraySum1(new int[]{28,54,7,-70,22,65,-6},100));

    }
}
