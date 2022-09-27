package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class duxiaoman {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k  = sc.nextInt();
//        int [] nk = new int[n];
//        int a=0;//所有可能
//        int b=0;//生气可能
//        for (int i=0;i<n;i++){
//            nk[i] = sc.nextInt();
//        }
//        Arrays.sort(nk);
//        for (int i=0;i<n;i++){
//            for (int j=i+1;j<n;j++){
//                if (nk[j]-nk[i]<=k){
//                    b++;
//                }
//                a++;
//            }
//        }
//        if (b==0){
//            System.out.println("0/1");
//        }else {
//            System.out.println(b+"/"+a);
//        }
//    }
public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    String ox = sc.nextLine();
    int m = sc.nextInt();
    String [] as = new String[m];
    int a= 0;
    for (int i=0;i<=m;i++){
        String ab = sc.nextLine();
        as[i-1] = ab;
    }
//    for (int i=0;i<m;i++){
//        for (int j=0;j<ox.length();j++){
//            if (ox.charAt(j)=='x'){
//                if (list.get(i).charAt(j)=='1'){
//                    System.out.println("NO");
//                    break;
//                }
//                else {
//                    System.out.println("YES");
//                }
//            }
//            else {
//                continue;
//            }
//        }
//    }

    System.out.println(ox);
    System.out.println(m);
    for (String a1:as){
        System.out.println(a1);
    }
}
}
