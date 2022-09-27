package com.bishi;

import java.util.Scanner;

/**
 * @author 东鑫
 */
public class LongHuan {
    public String translate(int n) {
        StringBuffer str = new StringBuffer();
        while (n > 0) {
            int m = n % 15;
            str.append((m >= 10 ? nu(m) : m));
            n /= 15;
        }

        return String.valueOf(str.reverse());
    }

    public String nu(int number) {
        if (number == 10) {
            return "A";
        } else if (number == 11) {
            return "B";
        } else if (number == 12) {
            return "C";
        } else if (number == 13) {
            return "D";
        } else {
            return "E";
        }
    }

    public static void main(String[] args) {
        String translate = new LongHuan().translate(235);
        System.out.println(translate);
    }
}
