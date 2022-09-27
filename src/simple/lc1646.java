package simple;

import java.util.Arrays;

public class lc1646 {
    public int getMaximumGenerated(int n) {
        Integer[] maxInt = new Integer[n+1];
        int a = 0;
        maxInt[0] = 0;
        if (n==0){
            return 0;
        }
        maxInt[1] = 1;
        if (n==1){
            return 1;
        }
        for (int i=2;i<=n;i++){
            if (i%2==0){
                maxInt[i] = maxInt[i/2];
            }else {
                maxInt[i] = maxInt[i/2+1] + maxInt[i/2];
            }
        }
        Arrays.sort(maxInt);
        a = maxInt[n];
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new lc1646().getMaximumGenerated(15));
    }
}
