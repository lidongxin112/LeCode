package y2026.May;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class lc523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i; j < n; j++) {
                if (j - i < 1){
                    continue;
                }
                sum += nums[j];
                if (k != 0 && sum <= k ? sum -k == 0 : sum % k == 0) {
                    return true;
                }
                if (sum == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {

        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j - i < 1){
                    continue;
                }
                int sum = preSum[j + 1] - preSum[i];
                if (k != 0 && sum <= k ? sum -k == 0 : sum % k == 0) {
                    return true;
                }
                if (sum == 0){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkSubarraySum4(int[] nums, int k) {

        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(preSum[i-2] % k);
            if (set.contains(preSum[i] % k)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkSubarraySum3(int[] nums, int k) {
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] == 0 && nums[i] == 0) {
                    return true;
                }
            }
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = (int) (sum % k);
            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new lc523().checkSubarraySum(new int[]{23,2,4,6,7}, 6));
        System.out.println(new lc523().checkSubarraySum4(new int[]{5,0,0,0}, 3));
        System.out.println(new lc523().checkSubarraySum3(new int[]{1,0}, 2));

    }

}
