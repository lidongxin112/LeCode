package simple;

import java.util.Arrays;

public class lc541 {
    /*
    如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     */
    public String reverseStr(String s, int k) {
        String a = "";
        String ba = "";
        StringBuilder sb = new StringBuilder();
        int j = k;
        int b = s.length();

        if (b % j == 0) {
            for (int i = 1; i <=b / j; i++) {
                if (i % 2 == 0) {
                    a = s.substring((i - 1) * j,i* j);
                    ba += a;
                } else {
                    a = s.substring((i - 1) * j, i * j);
                    sb = new StringBuilder(a);
                    ba += String.valueOf(sb.reverse());
                }
            }
        } else {
            for (int i = 1; i <= b / j + 1; i++) {
                if (i % 2 == 0) {
                    if (i * j > b) {
                        a = s.substring((i - 1) * j, b);
                    } else {
                        a = s.substring((i - 1) * j, i * j);
                    }
                    ba += a;
                } else {
                    if (i * j > b) {
                        a = s.substring((i - 1) * j, b);
                    } else {
                        a = s.substring((i - 1) * j, i * j);
                    }
                    sb = new StringBuilder(a);
                    ba += String.valueOf(sb.reverse());
                }
            }
        }
        return ba;
    }

    public static void main(String[] args) {
        String s = new lc541().reverseStr("abcdef", 3);
        // 预计                               "bacdfeg"
        String aa = "abcdef";
        System.out.println(aa.substring(4,6));
        System.out.println(1/2);
        System.out.println(s);
    }
}
