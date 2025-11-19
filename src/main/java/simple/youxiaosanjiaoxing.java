package simple;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class youxiaosanjiaoxing {
    public static int tran(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    ++k;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return  ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] a = s.split(",");
        int []b = new int[a.length];
        for (int i=0;i<a.length;i++){
            b[i] = Integer.parseInt(a[i]);
        }
        System.out.println(tran(b));
    }
}