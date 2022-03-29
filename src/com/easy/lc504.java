package com.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 * @author 东鑫
 */
public class lc504 {
    public String convertToBase7(int num) {
        return Integer.toString(num,7);
    }

    public static void main(String[] args) {
        String s = new lc504().convertToBase7(100);
        System.out.println(s);
    }
}
