package simple;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包含三种字符的字符串：和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//有效的括号字符串

public class lc678 {
    public boolean checkValidString(String s){
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> asteriskStack = new LinkedList<>();
        int n = s.length();
        for (int i=0;i<n;i++){
            char c = s.charAt(i);
            if (c =='('){
                leftStack.push(i);
            }else if (c=='*'){
                asteriskStack.push(i);
            }else {
                if (!leftStack.isEmpty()){
                    leftStack.pop();
                }else if (!asteriskStack.isEmpty()){
                    asteriskStack.pop();
                }else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()){
            int leftIndex = leftStack.pop();
            int asteriskIndex = asteriskStack.pop();
            if (leftIndex>asteriskIndex){
                return false;
            }
        }
        return leftStack.isEmpty();
    }
    //贪心
    public boolean checkValidStrin1(String s){
        int minCount = 0,maxCount = 0;
        int n  = s.length();
        for (int i=0;i<n;i++){
            char c = s.charAt(i);
            if (c=='('){
                minCount++;
                maxCount++;
            }else if (c==')'){
                minCount = Math.max(minCount-1,0);
                maxCount--;
                if (maxCount<0){
                    return false;
                }
            }else {
                minCount = Math.max(minCount-1,0);
                maxCount++;
            }
        }
        return minCount==0;
    }
}
