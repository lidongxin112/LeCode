package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 东鑫
 */
public class lc525 {
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if (nums[i]==0){
                nums[i] = -1;
            }
        }
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (map.containsKey(sum)){
                count = Math.max(count,i - map.get(sum));
            }else {
                map.put(sum,i);
            }
        }
        return count;
    }
}
