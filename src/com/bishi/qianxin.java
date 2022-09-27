package com.bishi;

import java.util.*;

import static simple.SortCombination.Sc1;

public class qianxin {

    public static Stack<String> stack = new Stack<>();
    public static List<String> list = new ArrayList<>();
    public String[] Permutation (char[] seed, int size) {
        List<String> l = per(seed, size, 0);
        int n = l.size();
        String [] ss = new String[n];
        for (int i=0;i<n;i++){
            ss[i] = l.get(i);
        }
        return ss;
    }
    public List<String> per(char[] seed,int n,int a){
        String s = "";
        if (a==n){
            for (int i=0;i<n;i++){
                s +=  String.valueOf(stack.get(i));
            }
            list.add(s);
            s = "";
        }
        for (int i=0;i<seed.length;i++){
            if (!stack.contains(String.valueOf(seed[i]))){
                stack.add(String.valueOf(seed[i]));
                per(seed,n,a+1);
                stack.pop();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        char[] cd = {'0','1','2'};
        String[] a = new qianxin().Permutation(cd, 2);
        for (String aa:a){
            System.out.println(aa);
        }
//        String aaa= "";
//        aaa += String.valueOf('1') + String.valueOf('2');
//        System.out.println(aaa);
    }
}