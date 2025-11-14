package com.bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tengxun2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] aa = new int[n][1000];
        int[] aaa = new int[n];
        for (int i=0;i<n;i++){
            int c = sc.nextInt();
            for (int j=0;j<c;j++){
                aa[i][j] = sc.nextInt();
            }
        }
        for (int i=0;i<n;i++){
            aaa[i] = abc(aa,i);
        }
        for (int qqq:aaa){
            System.out.println(qqq);
        }
    }
    public static int abc(int[][] aa,int n) {

        int a = aa[n].length;
        int c = 0;
        int b = 0;
        int k = 0;
        int e =0 ;
        List<Integer> list = new ArrayList<>();
        while (k < a) {
            for (int i = 0; i < a; ) {
                b += aa[n][i];
                i += aa[n][i] + i;
                if (i > a) {
                    break;
                }
            }
            list.add(b);
            b = 0 ;
            k++;
        }
        for (int a1:list){
            e = Math.max(Math.max(0,a1),e);
        }
        return e;
    }
}
