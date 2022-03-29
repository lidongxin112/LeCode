package simple;

import java.util.ArrayList;
import java.util.List;
/*
耗时
 */
/**
 * 38. 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221
 * f(n) = n * f(n-1)
 */
public class lc38 {
    public String countAndSay(int n) {
        String a = "";
        if (n == 1) {
            a = a + 1;
        } else {
            String s = countAndSay(n - 1);
            String asa = asa(s);
            a = asa;
        }
        return a;
    }

    public String asa(String a) {
        a += 'a';
        int n = a.length();
        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        int j = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(j) == a.charAt(i)) {
                k++;
            } else {
                list1.add(k);
                list2.add(String.valueOf(a.charAt(j)));
                j = i;
                k = 1;
            }
        }
        String s = "";
        for (int i = 0; i < list1.size(); i++) {
            s += list1.get(i) + "" + list2.get(i);
        }
        return s;
    }

    public static void main(String[] args) {
        String s = new lc38().countAndSay(10);
        System.out.println(s);
//        String s1 = new lc38().asa("1211");
//        System.out.println(s1);


    }
}
