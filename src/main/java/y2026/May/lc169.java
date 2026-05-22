package y2026.May;

import java.util.HashMap;

public class lc169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > n/2){
                return nums[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(new lc169().majorityElement(nums));
    }
}
