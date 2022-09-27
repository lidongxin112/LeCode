package com.zifuchuan;

/**
 * @author 东鑫
 */
public class lc709 {
    public String toLowerCase(String s) {
        StringBuffer a = new StringBuffer();
        for (char c:s.toCharArray()){
            if (65<=c&&c<=90){
                c = (char) (c + 32);
            }
            a.append(c);
        }
        return String.valueOf(a);
    }

    public static void main(String[] args) {
        System.out.println('z' - 'Z');
        String hello = new lc709().toLowerCase("Hello");
        System.out.println(hello);
    }
}
