package simple;

import java.util.Arrays;

public class lc344 {
    public void reverseString(char[] s) {
        int a = s.length;
        int size = a;
        for (int i=0;i<a/2;i++){
            size--;
            char b = s[i];
            s[i] = s[size];
            s[size] = b;

        }
    }
}
