package com.easy;

public class lc434 {
    public int countSegments(String s) {
        if (s==null){
            return 0;
        }
        String []a = s.split(" ");
        return a.length;
    }

    public static void main(String[] args) {
        int i = new lc434().countSegments("");
        System.out.println(i);
    }
}
