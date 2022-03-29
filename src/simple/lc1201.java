package simple;


import java.util.HashSet;
import java.util.Set;

public class lc1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int aa = n + 1;
        int [] ugly = new int [aa+1];
        ugly[1] = 1;
        int p2 = 1,p3 = 1,p5 = 1;
        for (int i=2;i<=aa;i++){
            int num2 = ugly[p2] * a,num3 = ugly[p3] * b,num5 = ugly[p5] * c;
            ugly[i] = Math.min(Math.min(num2,num3),num5);
            if (ugly[i]==num2){
                p2++;
            }
            if (ugly[i]==num3){
                p3++;
            }
            if (ugly[i]==num5){
                p5++;
            }
//            System.out.println(ugly[i]);
        }
        return ugly[aa-1];
    }

    public static void main(String[] args) {
        System.out.println( new lc1201().nthUglyNumber(9,2,3,7));
    }
}
