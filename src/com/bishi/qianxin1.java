package com.bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class qianxin1 {
    public static int LSubSequence(int N, ArrayList<Integer> sequence) {
        // write code here
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < sequence.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (sequence.get(j) < sequence.get(i)) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    public static int count(ArrayList<String> arr) {
        // write code here
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (test(arr.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static boolean test(String s) {
        if (!s.contains("(") && !s.contains("(")) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
