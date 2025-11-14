package com.dynamicProgramming;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 */
public class lc91 {
    public int numDecodings(String s) {
        int n = s.length();
        int [] f = new int[n+1];
        f[0] = 1;
        for (int i=1;i<=n;i++){
            if (s.charAt(i-1)!='0'){
                f[i] += f[i-1];
            }
            if (i>1 && s.charAt(i-2)!='0' && ((s.charAt(i-2)-'0') * 10 + (s.charAt(i-1)-'0') )<=26){
                f[i] += f[i-2];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        int i = new lc91().numDecodings("11");
        System.out.println(i);
    }
}
