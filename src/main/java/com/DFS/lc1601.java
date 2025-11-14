package com.DFS;

import java.util.Arrays;

/**
 * 1601. 最多可达成的换楼请求数目
 * 我们有 n 栋楼，编号从 0 到 n - 1 。每栋楼有若干员工。由于现在是换楼的季节，部分员工想要换一栋楼居住。
 * 给你一个数组 requests ，其中 requests[i] = [fromi, toi] ，
 * 表示一个员工请求从编号为 fromi 的楼搬到编号为 toi 的楼。
 * 一开始 所有楼都是满的，所以从请求列表中选出的若干个请求是可行的需要满足每栋楼员工净变化为 0 。
 * 意思是每栋楼 离开 的员工数目 等于 该楼 搬入 的员工数数目。比方说 n = 3 且两个员工要离开楼 0 ，一个员工要离开楼 1 ，
 * 一个员工要离开楼 2 ，如果该请求列表可行，应该要有两个员工搬入楼 0 ，一个员工搬入楼 1 ，一个员工搬入楼 2 。
 * 请你从原请求列表中选出若干个请求，使得它们是一个可行的请求列表，并返回所有可行列表中最大请求数目。
 *
 * @author 东鑫
 */
public class lc1601 {
    /**
     *
     * for(int i=0;i<(1<<n);i++){
     *     for(int j=0;j<n;j++){
     *     if(j&(1<<i)){
     *     相应的处理
     *     }
     *     }
     * }
     */
    public int maximumRequests(int n, int[][] requests) {
        int[] de = new int[n];
        int m = requests.length;
        int k = requests[0].length;
        int ans = 0;
        //二进制枚举 1<<m
        for (int i = 0; i < 1 << m; i++) {
            int cnt = Integer.bitCount(i);

            if (cnt <= ans) {
                continue;
            }
            Arrays.fill(de, 0);

            //
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    ++de[requests[j][0]];
                    --de[requests[j][1]];
                }
            }
            boolean flag = true;
            for (int x : de) {
                if (x != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = cnt;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
