package com.easy;

/**
 * @author 东鑫
 * @date 20点17分
 * 1154. 一年中的第几天
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。
 * 每个月的天数与现行公元纪年法（格里高利历）一致。
 */
public class lc1154 {
    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);
        boolean year = false;
        int d = a % 100;
        if (d > 0) {
            year = true ? false : d % 4 == 0;
        } else {
            if (a % 400 == 0) {
                year = true;
            }
        }
        int ans = 0;
        for (int i = 1; i < b; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 12) {
                ans += 31;
            }
            if (i == 4 || i == 6 || i == 9 || i == 10 || i == 11) {
                ans += 30;
            }
            if (i == 2) {
                ans += 28;
            }
        }
            ans += c;

            if (b > 3 && year) {
                ans += 1;
            }
        return ans;

    }

    public static void main(String[] args) {
        int i = new lc1154().dayOfYear("2019-01-09");
        System.out.println(i);
    }
}
