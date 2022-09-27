package com.bishi;

import java.util.Stack;

/**
 * lc1614
 * ()的深度问题
 * @author 东鑫
 */
public class okexinglu {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                a = Math.max(a, stack.size());
                stack.pop();
            }
        }
        return a;
    }
}
