package simple;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SortCombination {

    public static char []Cb = {'1','2','3'};
    public static Stack<String> stack = new Stack<>();
    //全排列
    public static void Sc(char[] cb, int n, int a){
        List<Stack<String>> list =new ArrayList<>();
        if (a==n){
            System.out.println(stack);
            return;
        }
        for (int i=0;i<cb.length;i++){
            stack.add(String.valueOf(cb[i]));
            Sc(cb,n,a+1);
            stack.pop();
        }
    }

    //排列组合。。
    public static void Sc1(char [] cb,int n,int a){
        if (a==n){
            System.out.println(stack);
        }
        for (int i=0;i<cb.length;i++){
            if (!stack.contains(String.valueOf(cb[i]))){
                stack.add(String.valueOf(cb[i]));
                Sc1(cb,n,a+1);
                stack.pop();
            }
        }
    }
    //数组长度为n，选长度为nn(nn<=n)有多少种组合方式
    public static void Sc2(char[]cb,int n,int a,int b){
        Stack<String> stack = new Stack<>();
        if (a==n){
            System.out.println(stack);
            return;
        }
        for (int i=1;i<cb.length;i++){
            if (!stack.contains(cb[i])){
                stack.add(String.valueOf(cb[i]));
                Sc2(cb,n,a+1,i);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Sc1(Cb,3,0);
        }
    }
