package simple;

public class lc264 {
    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n + 1];
        ugly[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = ugly[p2] * 2, num3 = ugly[p3] * 3, num5 = ugly[p5] * 5;
            ugly[i] = Math.min(Math.min(num2, num3), num5);
            if (ugly[i] == num2) {
                p2++;
            }
            if (ugly[i] == num3) {
                p3++;
            }
            if (ugly[i] == num5) {
                p5++;
            }
        }
        return ugly[n];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
