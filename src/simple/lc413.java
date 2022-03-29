package simple;

import java.util.Scanner;

public class lc413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return 0;
        }
        int dp = 0;
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            if (nums[i - 1] - nums[i - 2] == nums[i - 2] - nums[i - 3]) {
                dp++;
            } else {
                dp = 0;
            }
            ans += dp;
        }
        return ans;
    }

    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        lc413 s = new lc413();
        s.isUgly(n);
    }
}
