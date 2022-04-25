package com.bishi;

import java.util.*;

/**
 * 四达时代的有线电视收视费
 * Description
 *
 * 四达时代在非洲部分国家开展广播电视运营服务，并提供付费节目包。现在需要统计某个用户全年订购的付费节目包的总金额。
 *
 *
 * Input
 * 每笔金额间用空格表示，精确到2位小数，假设给定用户购买月包，全年最多购买12次
 *
 *
 * Output
 * 用英文对统计结果的数值进行输出，小数点用point表示，每个英文单词间用空格表示
 */
/*
四达时代的新频道LOGO
Description

四达时代在非洲部分国家开展广播电视运营服务，同时运营了多个电视节目频道。现在四达时代准备新开一个电影频道，准备用Movie的大写M作为频道Logo的主体形象进行设计。为了更好的做宣传推广，考虑将这个M做成通用模板，可以填充任意字符。


Input
输入在一行给出1个正整数N（≤1000）和电影片名的字符串S，中间以空格分隔。假定电影片名中不会存在空格。


Output
输出新排列好的字符串
 */
public class sidashidai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s1 = str.split(" ");
        String s2 = s1[0];
        Integer num = Integer.valueOf(s2);
        String s3 = s1[1];
        System.out.println(printStr(num, s3));
    }
    public static String printStr(int n, String str) {
        if (n <= 1) return str;
        char[] chars = str.toCharArray();
        Map<Integer, StringBuilder> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,new StringBuilder());
        }
        boolean flag = true;
        int count = 0;
        for (char aChar : chars) {
            map.get(count).append(aChar);
            if (flag) {
                count++;
                if (count == n - 1) flag = false;
            } else {
                count--;
                if (count == 0) flag = true;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = n-1; i >=0; i--) {
            builder.append(map.get(i));
        }
        return builder.toString();

    }
}
