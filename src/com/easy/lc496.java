package com.easy;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * <p>
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 */
public class lc496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = m - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int []res = new int[n];
        for (int i=0;i<n;i++){
            res [i] = map.get(nums1[i]);
        }
        return res;
//        int [] res = new int[n];
//        int c = 0;
//        for (int i=0;i<n;i++){
//            int a = nums1[i];
//            for(int j=0;j<m;j++){
//                int b = nums2[j];
//                if (a==b){
//                    if (j+1==m){
//                        c= -1;
//                    }
//                     else {
//                        c = a > nums2[j + 1] ? -1 : nums2[j + 1];
//                    }
//                     break;
//                }
//            }
//            res[i] = c;
//        }
//        return res;
    }

    public static void main(String[] args) {
        int []num1 = {4,1,2};
        int [] num2 ={1,3,4,2};
        int[] ints = new lc496().nextGreaterElement(num1, num2);
        for (int i:ints){
            System.out.println(i);
        }
    }
}
