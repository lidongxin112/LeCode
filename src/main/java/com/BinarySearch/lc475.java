package com.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 东鑫
 * 475. 供暖器
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，
 * 请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * <p>
 * 判断暖气是否在同一水平的房屋内
 */
public class lc475 {
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        int d = (int) 2e9;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0;
        for (int i = 0; i < houses.length; i++) {
            while (j < heaters.length && heaters[j] < houses[i]) {
                j++;
            }
            if (j == 0) {
                d = heaters[0] - houses[i];
            } else if (j == heaters.length) {
                d = houses[i] - heaters[j - 1];
            } else {
                d = Math.min(heaters[j] - houses[i], houses[i] - heaters[j - 1]);
            }
            ans = Math.max(ans, d);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] houses = {1, 5};
        int[] heaters = {2};
        int radius = new lc475().findRadius(houses, heaters);
        System.out.println(radius);
    }
}
