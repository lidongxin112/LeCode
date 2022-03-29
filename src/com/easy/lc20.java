package com.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class lc20 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n%2!=0){
            return false;
        }
        Map<Character,Character> pair = new HashMap<Character, Character>(){{
            put(')','(');
            put('}','{');
            put(']','[');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i=0;i<n;i++){
            char ch = s.charAt(i);
            if (pair.containsKey(ch)){
                if (stack.isEmpty()|| !stack.peek().equals(pair.get(ch))){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
