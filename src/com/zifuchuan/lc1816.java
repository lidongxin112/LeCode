package com.zifuchuan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 东鑫
 */
public class lc1816 {
    public String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        String str = "";
        for (int i=0;i<k;i++){
            str +=s1[i] + " ";
        }
        return str.substring(0,str.length()-1);
    }

    public static void main(String[] args) {
        String a = new lc1816().truncateSentence("Hello how are you Contestant", 4);
        System.out.println(a);
    }
}
