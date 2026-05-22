package y2026.May;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 示例 3：
 *
 * 输入：intervals = [[4,7],[1,4]]
 * 输出：[[1,7]]
 * 解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
 *
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class lc56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1){
            return intervals;
        }
        int[] start = new int[n];
        int[] end = new int[n];
        LinkedList<int[]> res = new LinkedList<>();
        for (int i=0;i<n;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i=0;i<n;i++){
            int starts = start[i];
            while (i < n-1 && end[i] >= start[i+1]) {
                i++;
            }
            res.add(new int[]{starts,end[i]});
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] ints = new lc56().merge(intervals);
        for (int[] a:ints){
            System.out.println(a[0]+" "+a[1]);
        }
        System.out.println("===================");
        intervals = new int[][]{{1,4},{4,5}};
        ints = new lc56().merge(intervals);
        for (int[] a:ints){
            System.out.println(a[0]+" "+a[1]);
        }
        System.out.println("===================");
        intervals = new int[][]{{4,7},{1,4}};
        ints = new lc56().merge(intervals);
        for (int[] a:ints){
            System.out.println(a[0]+" "+a[1]);
        }
        System.out.println("===================");
        intervals = new int[][]{{1,4},{5,6}};
        ints = new lc56().merge(intervals);
        for (int[] a:ints){
            System.out.println(a[0]+" "+a[1]);
        }

    }
}
