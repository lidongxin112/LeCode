package y2026.April;

import java.util.HashMap;

public class lc1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        lc1 lc = new lc1();
        int[] ints = lc.twoSum(nums, target);
        for (int i = 0; i < ints.length; i++){
            System.out.println(ints[i])
            ;
        }
    }
}
