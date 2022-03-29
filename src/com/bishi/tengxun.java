package com.bishi;

import java.util.Scanner;

public class tengxun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int [] tt = new int[t];
        int[] tt1 = new int[t];
        for (int i=0;i<t;i++){
            tt[i] = sc.nextInt();
        }
        for (int i=0;i<t;i++){
            tt1[i] = aa(tt[i]);
        }
        for (int i:tt1){
            System.out.println(i);
        }
    }
    public static int aa(int a){
        int a1 = a + 1;
        int b1 = 2 * a + 1;
        int c = 0;
        int b = 1;
        int n = a1 * b1;
        while (c<a){
            for (int i=2;i<n;i++){
                if (n % i==0 && i -1 >a){
                    continue;
                }
            }
            n++;
        }

        return n;
    }
}
