package com.bishi;

import java.util.*;

/**
 * @author 东鑫
 */
public class weilai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] he = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                he[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(he[i][j]);
            }
            System.out.println();
        }
    }

    //Calculate the distance from a point[x,y] to a triangle points are ordered in the counter-clockwise direction
    public List<List<Integer>> num(int[][] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<Integer> set = new HashSet<>();


        return lists;
    }

    public int[] sortCars(int[] nums) {
        // write code here
        Arrays.sort(nums);

        return nums;
    }

    public float calculateDistance(float[] point, float[][] triangle) {
        // write code here
        String s = "0";
        float legnth = Float.parseFloat(String.format("%.4f",s));
        if (triangle.length<3){
            return legnth;
        }
        float max1 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE;
        float max2 = Integer.MIN_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.length; i++) {
            max1 = Math.max(max1,triangle[i][0]);
            min1 =  Math.min(max1,triangle[i][0]);
            max2 = Math.max(max1,triangle[i][1]);
            min2 =  Math.min(max1,triangle[i][1]);
        }
        if (min1 <=point[0] && point[0]<=max1){
            if (min2 <=point[1] && point[1]<=max2){
                return legnth;
            }
        }
        float[] of = new float[3];
        for (int i=0;i<triangle.length;i++){
            of[i] = Math.abs(point[0]) + Math.abs(triangle[i][0]) + Math.abs(point[1]) + Math.abs(triangle[i][1]);
        }
        List<Float> list = new ArrayList<>();
        float a = of[0] + of[1];
        float b = of[0] + of[2];
        float c = of[1] + of[2];
        float d = 0l;
        float min = Math.min(a, Math.min(b, c));
        if (a == min){
            a = 0;
        }
        if (b == min){
            b = 0;
        }if (c == min){
            c = 0;
        }
        for (int i=0;i<3;i++){

        }


        return legnth;
    }
}
