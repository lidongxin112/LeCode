package com.easy;

/**
 *66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 */
public class lc66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        long a = 0;
        for (int i=0;i<n;i++){
            a+= digits[i] * Math.pow(10,n-i-1);
        }
        a = a + 1;
        String a1 = String.valueOf(a);
        int c = a1.length();
        int [] aa = new int[c];
        for (int i=0;i<c;i++){
            aa[i] = a1.charAt(i) - 48;
        }
        return aa;
    }


    public static void main(String[] args) {
        int []a = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        int[] ints = new lc66().plusOne(a);
        for (int i:ints){
            System.out.println(i);
        }


    }
}
