package com.easy;

import java.util.ArrayList;
import java.util.List;

public class lc500 {
    public String[] findWords(String[] words) {
        int[] arr = new int[26];
        for (char ch : "qwertyuiiop".toCharArray()) {
            arr[ch - 'a'] = 1;
        }
        for (char ch : "asdfghjkl".toCharArray()) {
            arr[ch - 'a'] = 2;
        }
        for (char ch : "zxcvbnm".toCharArray()) {
            arr[ch - 'a'] = 3;
        }
        List<String> list = new ArrayList<>();
        for (String word : words) {
            int a = 0, b = 0, c = 0;
            for (char ch : word.toCharArray()) {
                ch = Character.toLowerCase(ch);
                if (arr[ch - 'a'] == 1) {
                    a++;
                }
                else if (arr[ch - 'a'] == 2) {
                    b++;
                }
                else if (arr[ch - 'a'] == 3){
                    c++;
                }
                }
            if (a==word.length()||b==word.length()||c==word.length()){
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        String []a = {"Hello","Alaska","Dad","Peace"};
        String[] words = new lc500().findWords(a);
        for (String aw:words){
            System.out.println(aw);
        }
    }
}
