package simple;

import java.util.Arrays;
import java.util.Scanner;

public class DouYu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = "";
        int[] a1 = new int[2];
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'm' || a.charAt(i) == 'n' || a.charAt(i) == '=' || a.charAt(i) == ',') {
                continue;
            } else {
                b += a.charAt(i);
            }
        }
        for (int i = 0; i < 2; i++) {
            a1[i] = b.charAt(i) - 48;
        }
        int [] a2 = new int[a1[0]+a1[1]];
        int [] a3 = new int[a1[1]];
        String b1 = sc.nextLine();
        String b2[] = b1.split(",");
        for (int i=0;i<a1[0];i++){
            a2[i] = Integer.parseInt(b2[i]);
        }
        String b3 = sc.nextLine();
        String b4[] = b3.split(",");
        for (int i=0;i<a1[1];i++){
            a3[i] = Integer.parseInt(b4[i]);
        }


        for (int i=a1[0];i<a2.length;i++){
            a2[i] = a3[i-a1[0]];
        }
        Arrays.sort(a2);
        for (int a222:a2){
            System.out.print(a222);
            System.out.print(" ");
        }
    }
}
