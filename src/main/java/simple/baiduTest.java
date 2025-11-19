package simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baiduTest {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[][] nk1 = new int[n][n];
//        int[][] nk2 = new int[n * k][n * k];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                nk1[i][j] = sc.nextInt();
//            }
//        }
//        for (int i=0;i<n * k;i++){
//            for (int j = 0;j<n * k;j++){
//
//            }
//        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
//        int[] t1 = new int[t];
//        for(int i=0;i<t;i++){
//            t1[i] = sc.nextInt();
//        }
        System.out.println(retu(t));
    }
    public static int retu(int y){
        int x = 0;
        for (int i=y-1;i>0;i--){
            if (i<=10){
                if (y>3){
                    return 3;
                }else {
                    return y;
                }
            }else { while (i%10!=0){
                    x = i % 10;
                    if (x==1||x==2||x==3){
                        i = i /10;
                    }else {
                        break;
                    }
                }
                return i;
                }
        }
        return 1;
    }
    public static Boolean aa(int i){
        int x = 0;
        while (i%10!=0){
            x = i % 10;
            if(x!=1||x!=2||x!=3){
                return false;
            }else {
                i = i/10;
                return true;
            }

            }
        return false;
    }
}
