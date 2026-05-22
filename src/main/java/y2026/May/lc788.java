package y2026.May;

/**
 * 788. 旋转数字
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 *
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 *
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 *
 *
 *
 * 示例：
 *
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 *
 *
 * 提示：
 *
 * N 的取值范围是 [1, 10000]。
 */
public class lc788 {
    //dp[n] = dp[n-1] + n是不是好数
    public int rotatedDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i < 10) {
                if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = dp[i - 1] + 1;
                }else {
                    dp[i] = dp[i - 1];
                }
            } else {
                int x = i;
                boolean flag = true;
                while (x > 0){
                    int temp = x % 10;
                    if (temp == 2 || temp == 5 || temp == 6 || temp == 9) {
                        flag = false;
                    } else if (temp == 3 || temp == 4 || temp == 7) {
                        flag = true;
                        break;
                    }
                    x = x / 10;
                }
                if (!flag) {
                    dp[i] = dp[i - 1] + 1;
                }else {
                    dp[i] = dp[i - 1];

                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(new lc788().rotatedDigits(10));
    }
}
