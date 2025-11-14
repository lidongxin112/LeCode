package com.zifuchuan;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 东鑫
 * 1405. 最长快乐字符串
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 * <p>
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 * <p>
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 */
public class lc1405 {
    public String longestDiverseString(int a, int b, int c) {
        int[] n = new int[3];
        n[0] = a;
        n[1] = b;
        n[2] = c;
        Arrays.sort(n);

        return null;
    }
}
