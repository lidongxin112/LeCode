package com.weiyunsuan;

/**
 * 693. 交替位二进制数
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 *
 * @author 东鑫
 */
public class lc693 {
    public boolean hasAlternatingBits(int n) {

        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }
}
