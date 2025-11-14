package com.shuzu;

import java.util.*;

/**
 * @author 东鑫
 */
public class lc539 {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n < 2) {
            return 0;
        }
        int[] time = new int[n];
        int a = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            String[] split = timePoints.get(j).split(":");
            int fs = Math.abs(Integer.parseInt(split[0]) - 0) * 60;
            int fxa = Integer.parseInt(split[1]) - 0;
            time[j] = fs + fxa;
        }
        Arrays.sort(time);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int cs = time[j] - time[i];
                if (cs > 1200) {
                    cs = 1440 - cs;
                }
                a = Math.min(a, cs);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("23:59");
        list.add("00:00");
//        list.add("01:01");
//        list.add("02:01");
//        list.add("03:00");
//        list.add("03:01");
        list.add("04:00");
        list.add("22:00");

        int minDifference = new lc539().findMinDifference(list);
        System.out.println(minDifference);
    }
}
