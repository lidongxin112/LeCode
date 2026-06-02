package y2026.May;

import java.util.Stack;

public class lc20 {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
                stack.push(charArray[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if (charArray[i] == ')' && c != '(') {
                    return false;
                }
                if (charArray[i] == ']' && c != '[') {
                    return false;
                }
                if (charArray[i] == '}' && c != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(new lc20().isValid("()"));
        System.out.println(new lc20().isValid("()[]{}"));
        System.out.println(new lc20().isValid("(]"));
        System.out.println(new lc20().isValid("([)]"));
        System.out.println(new lc20().isValid("{[]}"));
    }
}
