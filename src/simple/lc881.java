package simple;

import java.util.Arrays;
import java.util.Scanner;

public class lc881 {
//    public int numRescueBoats(int[] people, int limit) {
//        int a = 0;
//        int len = 0;
//        int maxLen = people.length - 1;
//        Arrays.sort(people);
//        while (len <= maxLen) {
//            if (len == maxLen) {
//                a++;
//                break;
//            }
//            if (people[len] + people[maxLen] > limit) {
//                a++;
//                maxLen--;
//            } else {
//                a++;
//                len++;
//                maxLen--;
//            }
//        }
//        return a;
//    }
        public int numRescueBoats(int[] people) {
            Arrays.sort(people);
            int a = people.length;
            int num = 0;
            for (int i=0;i<a;i++){
                for (int j=i+1;j<a;j++){
                    if (people[i]==people[j]){
                        people[j]++;
                        num++;
                    }
                }
            }
            return num;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] pe = s.split(",");
        int[] a = new int[pe.length];
        for (int i = 0; i < pe.length; i++) {
            a[i] = Integer.parseInt(pe[i]);
        }

        System.out.println(new lc881().numRescueBoats(a));
    }
}