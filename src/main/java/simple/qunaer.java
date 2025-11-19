package simple;

import sun.misc.Queue;

import java.util.*;

public class qunaer {
    //    public String solution(int[] d) {
//        Arrays.sort(d);
//        int n = d.length;
//        if (n<=0){
//            return "";
//        }
//        System.out.println(n);
//        String s = "";
//        for (int i = n-1; i >= 0; i--) {
//            int aa = d[i];
//            if (aa % 3 == 0) {
//                s += d[i];
//            }
//        }
//        return s;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String res;
//        int _d_size = 0;
//        _d_size = Integer.parseInt(in.nextLine().trim());
//        int[] _d = new int[_d_size];
//        int _d_item;
//        for (int _d_i = 0; _d_i < _d_size; _d_i++) {
//            _d_item = Integer.parseInt(in.nextLine().trim());
//            _d[_d_i] = _d_item;
//        }
//
//        res = new qunaer().solution(_d);
//        System.out.println(res);
//    }

    /*
5
-1
1
4
-9
-8
*/

    public int solution(int[] arr) {
        int n = arr.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        int d[] = arr;
        Arrays.sort(d);
        int  d1 = 0;
        for (int i = 0; i < n; i++) {
            if (d[i] < 0) {
                list1.add(d[i]);
            } else {
                list2.add(d[i]);
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            if (Math.abs(list1.get(i)) <= list2.get(0)) {
                list3.add(list1.get(i));
            }
        }
        int c = list3.size();
        System.out.println(c);
        for (int i = 1; i <= list3.size(); i++) {
            d1 += i * list3.get(i - 1);
        }
        for (int i = list3.size() +  1; i <= list2.size() + c; i++) {
            d1 += i * list2.get(i-c);
        }
        return d1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = new qunaer().solution(_arr);
        System.out.println(String.valueOf(res));

    }
    /**
     * 优雅的字符串
     * 时间限制： 3000MS
     * 内存限制： 589824KB
     * 题目描述：
     * Lisa 喜欢字符串，尤其是长字符串。对于每个字符串，她都有专门的评价体系来判断字符串的优雅程度。她定义一个字符串 S[1..3n−2] (n≥2) 是一个半回文当且仅当它满足 S[i]=S[2n−i]=S[2n+i− 2] (1≤i≤n) .例如dfgfdfg是一个半回文串，而dfgjfdfgj不是。现在，Lisa 生成了一些长字符串。她请求你帮助找出有多少个半回文子串。
     *
     *
     *
     * 输入描述
     * 第一行为测试用例数n；
     *
     * 每个测试用例，只有一行包含一个字符串（字符串的长度小于或等于 100000），该字符串仅由小写字母组成。
     *
     * 对于本题：我们只考察n=1的情况。
     *
     * 输出描述
     * 对于每个测试用例，输出一个整数，表示一个半回文子串的数量。
     */
}
