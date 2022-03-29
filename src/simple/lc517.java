package simple;

import java.util.Arrays;

/**
 * 517. 超级洗衣机
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 *
 * 在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 *
 * 给定一个整数数组 machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。
 */
public class lc517 {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int a = Arrays.stream(machines).sum();
        if (a % n !=0){
            return -1;
        }
        int avg = a / n;
        int ans = 0,sum = 0;
        for (int num:machines){
            num -= avg;
            sum += num;
            ans = Math.max(ans,Math.max(Math.abs(sum),num));
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] a = {4,0,0,4};
        int minMoves = new lc517().findMinMoves(a);
        System.out.println(minMoves);
    }
}
