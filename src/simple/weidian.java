package simple;

import java.util.Scanner;

public class weidian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        String c = new weidian().aBoolean(a, b);
        System.out.println(c);

    }
    public String aBoolean(String a,String b){
        int a1 = a.length();
        int b1 = b.length();
        int i = 0, j = 0;
        while (i < b1 && j < a1) {
            if (b.charAt(i)==a.charAt(j)){
                ++i;
            }
            ++j;
        }
        if (i==b1){
            return "yes";
        }

        return "no";
    }
}
