package y2026.May;

public class lc136 {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i=0;i<nums.length;i++){
             a = nums[i] ^ a;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        System.out.println(new lc136().singleNumber(nums));
    }
}
