package com.zifuchuan;

/**
 * 1446. 连续字符
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 *
 * 请你返回字符串的能量。
 * @author 东鑫
 */
public class lc1446 {
    public int maxPower(String s) {
        int count=1,max=0;
        for(int i=1;i<s.length();i++){
            count+=s.charAt(i)==s.charAt(i-1)?1:-count+1;
            max = Math.max(max,count);
        }
        return max;
    }

    public static void main(String[] args) {
        int leetcode = new lc1446().maxPower("leetcode");
        System.out.println(leetcode);
    }
}
