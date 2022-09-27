package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 786. 第 K 个最小的素数分数
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，
 * 且其中所有整数互不相同。
 *
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 *
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且
 * answer[1] == arr[j] 。
 */
public class lc796 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        List<int []> frac = new ArrayList<>();
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                frac.add(new int[]{arr[i],arr[j]});
            }
        }
        Collections.sort(frac,(x,y)->x[0] * y[1] - y[0]*x[1]);
        return frac.get(k-1);
    }
}
