package com.bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class metpp {
    public static int answer(int[] x) {
        int an = an(x);
        List<Integer> list = an1(an);
        int i = an2(list);
        return i;
    }

    public static int an(int[] x) {
        if (x.length == 0) {
            return 6;
        }
        int sum = 0;
        if (x.length % 2 == 0) {
            int a = x.length < 7 ? x.length : 7;
            for (int i = 0; i < a; i++) {
                sum += x[i];
            }
        }else {
            int a = x.length < 6 ? x.length : 6;
            for (int i = 0; i < a; i++) {
                sum += x[i];
            }
        }

        return sum;
    }
    public static List<Integer> an1(int x) {
        List<Integer> list = new ArrayList<>();
        while (x>0){
            int a = x % 10;
            list.add(a);
            x = x / 10;
        }
        int n = list.size();
        for (int i=0;i<7;i++){
            for (int j=0;j<n;j++){
                list.add(list.get(j));
            }
        }
        return list;
    }
    public static int an2(List<Integer> list){
        int []a = new int[list.size()];
        for (int i=0;i<list.size();i++){
            a[i] = list.get(i);
        }
        Arrays.sort(a);
        int sum = 0;
        if (list.size()==1){
            return 2;
        }
        int res = 0;
        for (int i=1;i<list.size();i++){
            if (a[i]>a[i-1] + 2){
                res = res + 2;
            }else {
                res = res + (a[i] - a[i-1]);
            }
        }
        return res + 2;
    }

    public static void main(String[] args) {
        int [] a = {79,583,13,787,136,881,271};
        System.out.println(answer(a));
    }
    }
