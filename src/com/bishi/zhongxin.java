package com.bishi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class zhongxin {
    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        if (s.length()<=1){
//            System.out.println(s);
//        }
//        Map<Character,Integer> map = new HashMap<>();
//        for (int i=0;i<s.length();i++){
//
//            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
//        }
//        for (Character na: map.keySet()){
//            if (map.get(na)>=2){
//                System.out.print(na);
//            }
//        }
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] jz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                jz[i][j] = sc.nextInt();
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                System.out.print(jz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/*


        if (n % 2 == 0) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    System.out.print(jz[i][j]+ " ");
                }
                System.out.println();
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    System.out.print(jz[i][j]+ " ");
                }
                System.out.println();
            }
        }
    }
 */
