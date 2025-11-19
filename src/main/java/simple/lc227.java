package simple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 */
public class lc227 {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int n  =chars.length;
        int s2 = 0;
        int num = 0;
        for (int i=0;i<n;i++){
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                }
                preSign = s.charAt(i);
                num = 0;
            }

        }
        while (!stack.isEmpty()){
            s2+=stack.pop();
        }
        return s2;
    }

    public static void main(String[] args) {
        int bl = new lc227().calculate("3+2*2");
        System.out.println(bl);
    }
}
