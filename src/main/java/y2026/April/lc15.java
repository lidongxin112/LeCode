package y2026.April;

import java.util.*;

public class lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> lists = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            int target = -nums[i];
            for (int k = i + 1; k < nums.length; k++){
                List<Integer> list = new ArrayList<Integer>();
                    if (map.containsKey(target - nums[k])){
                        list.add(nums[i]);
                        list.add(nums[k]);
                        list.add(target - nums[k]);
                        list.sort(null);
                        lists.add(list);
                    }
                    map.put(nums[k], k);
                }
            }
        return lists.stream().toList();
        }
        public static void main(String[] args) {
            int[] nums = {-1, 0, 1, 2, -1, -4};
            lc15 lc = new lc15();
            System.out.println(lc.threeSum(nums));
        }
    }
