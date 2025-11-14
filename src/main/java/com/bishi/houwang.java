package com.bishi;

import java.util.HashMap;
import java.util.Map;

/*
选侯王
 */
public class houwang {
    public static int DoPermute (int M, int N) {
        // write code here
        int monkey[] = new int[M];
        for (int i=0;i< monkey.length;i++){
            monkey[i] = i+1;
        }
        int count = 1;
        int king = 0;
        int index = 0;
        while (M!=0){
            if (index==monkey.length){
                index = 0;
            }
            if (count==N && monkey[index]!=0){
                monkey[index] = 0;
                M--;
                count=1;
            }


            if (monkey[index]!=0){
                count++;
            }
            index++;
        }
        king = index;
        return king;
    }

    public static void main(String[] args) {
        int i = DoPermute(5, 3);
        System.out.println(i);
    }
}
