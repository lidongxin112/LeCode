package y2026.May;

import java.util.HashMap;

public class lc2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int []C = new int[n];
        for (int i=0;i<n;i++){
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
            if (A[i] == B[i]){
                if (map.get(A[i]) >= 2){
                    sum++;
                }
            }else {
                if (map.get(A[i]) >= 2){
                    sum++;
                }
                if (map.get(B[i]) >= 2){
                    sum++;
                }
            }
            C[i] = sum;
        }
        return C;
    }

    public static void main(String[] args) {
        int[]A = new int[]{1,3,2,4};
        int[]B = new int[]{3,1,2,4};
        int[] ints = new lc2657().findThePrefixCommonArray(A, B);
        for (int a:ints){
            System.out.println(a);
        }

    }
}
