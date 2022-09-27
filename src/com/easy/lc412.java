package com.easy;

import java.util.ArrayList;
import java.util.List;

public class lc412 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i=1;i<=n;i++){
            if (i % 3==0 && i % 5==0){
                list.add("FizzBuzz");
            }
            else if (i % 3==0){
                list.add("Fizz");
            }
            else if (i % 5==0){
                list.add("Buzz");
            }else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new lc412().fizzBuzz(15);
        for(String a:list){
            System.out.println(a);
        }
    }
}
