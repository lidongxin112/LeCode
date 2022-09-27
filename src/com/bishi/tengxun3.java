package com.bishi;

import java.util.Scanner;
import java.util.Stack;

/**
 * 10+2@1x2
 */
public class tengxun3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = getSum(2, 3);
        System.out.println(r);
    }
    public int a(String s){
        int a = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<a;i++){
            if (s.charAt(i) == '@'){

            }
        }
        return 1;
    }
    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
