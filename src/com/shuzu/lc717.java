package com.shuzu;

/**
 * @author 东鑫
 * 717. 1比特与2比特字符
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 */
public class lc717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }

    public static void main(String[] args) {
        int[] a = {1,0,0};
        boolean oneBitCharacter = new lc717().isOneBitCharacter(a);
        Integer a1 = 1;
        Integer b = 1;
        System.out.println(a1>b);
    }
    //李东鑫 6018203275 软件工程 移动云3班 15203255003
}
