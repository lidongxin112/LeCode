package simple;

import java.util.Arrays;

public class lc17 {
        public int[] smallestK(int[] arr, int k) {
            int [] a = new int[k];
            if (k==0){
                return a;
            }

            Arrays.sort(arr);
            for (int i=0;i<k;i++){
                a[i] = arr[i];
            }
            return a;
        }

    public static void main(String[] args) {
        int[]b = {1,3,5,7,2,4,6,8};
        int[] ints = new lc17().smallestK(b, 0);
        for (int a1:ints){
            System.out.println(a1);
        }
    }
}
