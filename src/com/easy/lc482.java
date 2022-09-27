package com.easy;

/**
 * 482. 密钥格式化
 * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
 *
 * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 *
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 */
public class lc482 {
    public String licenseKeyFormatting(String s, int k) {
        String a = s.replaceAll("-","");
        if(a.length()==0){
            return "";
        }
        System.out.println(a);
        String b1 = "";
        int n = a.length();
        int b = n % k;
        int c =  b;
        for(int i=0;i<n&&c<=n;){
            if (b!=0){
                b1 += a.substring(i,c) + "-";
                i = c;
                c += k;
            }else {
                b1+=a.substring(i,i+k) + "-";
                i+=k;
            }
        }
        String aas = b1.substring(0,b1.length()-1);
        return aas.toUpperCase();
    }

    public static void main(String[] args) {
        String s = new lc482().licenseKeyFormatting("---", 3);
//        System.out.println(s);
//        System.out.println((char)98);
        String a = "---";
        String a1 = a.replaceAll("-","");
        System.out.println(a1.length());
    }
}
