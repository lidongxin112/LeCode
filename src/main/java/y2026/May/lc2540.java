package y2026.May;

import java.util.HashSet;
import java.util.Set;

public class lc2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums1){
            set.add(i);
        }
        for (int i:nums2){
            if (set.contains(i)){
                return i;
            }
        }
        return -1;
    }
    public int getCommon2(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){
                return nums1[i];
            }
            if (nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4};
        System.out.println(new lc2540().getCommon(nums1, nums2));
    }
}
