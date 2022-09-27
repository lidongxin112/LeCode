package com.bishi;

import java.util.ArrayList;
import java.util.List;

public class mep {

    public static int answer(int x) {
        x = x * 13;
        int [] a = answer1(x);
        if (a==null){
            return 0;
        }else if (a.length==1){
            return a[1];
        }
        return 1;
    }
    public static int[] answer1(int x){
        int z=1;
        int[] aba;
        List<Integer> list = new ArrayList<>();
        if (x>2) {
            for (int i = 1; i <= 2; i++) {
                list.add(i);
            }
        }else{
                list.add(1);
            }
        aba = new int[list.size()];
        for (int i=0;i<list.size();i++){
            aba[i] = list.get(i);
        }
        return aba;
    }




    public static void main(String[] args) {
        int answer = answer(587);

    }
}
