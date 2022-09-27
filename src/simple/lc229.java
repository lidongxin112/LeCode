package simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc229 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        int a = n / 3;
        for (int i:map.keySet()){
            if (map.get(i)>a){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int [] nums = {3,2,3};
        List<Integer> list = new lc229().majorityElement(nums);
        for (int i:list){
            System.out.println(i);
        }
    }
}
