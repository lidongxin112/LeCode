package com.bishi;

import java.util.Scanner;

/**
 * 递增三元组
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 在一个无序且可能包含重复数字的正整数序列A中，如果存在三个数字A[i]、A[j]和A[k]，它们满足i<j<k（i、j和k为三个数字在序列A中出现的位置），且A[i]<A[j]<A[k]，则称这三个数为一个递增三元组。 需要注意的是递增三元组中的三个数字不要求连续出现，例如：在正整数序列{1,2,3,4,5}中，(1,3,5)是一个满足要求的递增三元组。 现在给出一个正整数序列，请你编写一个程序找出和最大的递增三元组，输出该三元组中三个数字的和。 如果在序列A中不存在递增三元组则输出0。
 *
 *
 *
 * 输入描述
 * 单组输入。 第1行输入一个正整数N，表示正整数序列A中数字的个数。(N<=1000) 第2行输入N个正整数，对应序列A中的N个元素。两两之间用英文空格隔开，每一个正整数均不超过10^6。
 *
 * 输出描述
 * 输出和最大的递增三元组中的三个数字之和，如果在输入序列中不存在递增三元组则输出0。
 * 6
 * 2 3 5 3 6 4
 * 样例输出
 * 14
 */
public class jinshanyun1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int [] ab = new int[n];
        for (int i=0;i<n;i++){
            ab[i] = sc.nextInt();
        }
        int[] max1 = max(ab,ab.length);
        sum+=max1[0];
        int[] max2 = max(ab, max1[1]);
        sum+=max2[0];
        int[] max3 = max(ab, max2[1]);
        sum+=max3[0];
        System.out.println(sum);
    }
    public static int[] max(int[] aa,int n){
        int [] ac = new int[2];
        int a = 0;
        int b = 0;
        int c = Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            if (c<aa[i]){
                c = aa[i];
                a = aa[i];
                b = i;
            }

        }
        ac[0] = a;
        ac[1] = b;
        return ac;
    }

}
