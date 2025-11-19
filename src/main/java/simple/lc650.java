package simple;

/**
 * 650. 只有两个键的键盘
 * <p>
 * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 * <p>
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字n ，你需要使用最少的操作次数，在记事本上输出 恰好n个 'A' 。返回能够打印出n个 'A' 的最少操作次数。
 */
public class lc650 {
        public int minSteps(int n) {
            int[] f = new int[n + 1];
            for (int i = 2; i <= n; ++i) {
                f[i] = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; ++j) {
                    if (i % j == 0) {
                        f[i] = Math.min(f[i], f[j] + i / j);
                        f[i] = Math.min(f[i], f[i / j] + j);
                    }

                }
            }
                return f[n];
        }
}
