package com.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 东鑫
 * 868. 二进制间距
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，
 * 返回 0 。
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。
 * 两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 */
public class lc868 {
    public int binaryGap(int n) {
        String s = Integer.toString(n, 2);
        List<Integer> list = new ArrayList<>();
        int nn = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                list.add(i);
            }
        }
        if (list.size() <= 1) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            max = Math.max((list.get(i) - list.get(i-1)), max);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new lc868().binaryGap(15);
        System.out.println(i);
    }
}
