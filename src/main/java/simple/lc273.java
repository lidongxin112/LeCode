package simple;

import static sun.nio.cs.Surrogate.low;

/**
 *
 * 273. 整数转换英文表示
 * 将非负整数 num 转换为其对应的英文表示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 * 示例 2：
 *
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 * 示例 3：
 *
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 示例 4：
 *
 * 输入：num = 1234567891
 * 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class lc273 {
    String[] low = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String[] mid = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] high = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if (num==0){
            return "Zero";
        }
        int part1 = num % 1000;
        num = num / 1000;
        int part2 = num % 1000;
        num = num / 1000;
        int part3 = num % 1000;
        num = num / 1000;
        int part4 = num;
        String ans = "";
        if (part4!=0){
            ans = buildNumber(part4) + "Billion ";
        }
        if (part3!=0){
            ans = ans + buildNumber(part3) + "Million ";
        }
        if (part2!=0){
            ans = ans + buildNumber(part2) + "Thousand ";
        }
        if (part1!=0){
            ans = ans +buildNumber(part1);
        }
        return ans.trim();
    }
    public String buildNumber(int num){
        int a = num % 10;
        num = num / 10;
        int b = num % 10;
        num = num / 10;
        int c = num;
        String ans = "";
        if (c!=0){
            ans = low[c] + " " + "Hundred ";
        }
        if (b==1){
            ans = ans + mid[a];
        }else if (b==0){
            ans  = ans + low[a];
        }else {
            ans = ans + high[b] + "" + low[a];
        }
        return ans.trim() + " ";
    }

    public static void main(String[] args) {
        String s = new lc273().numberToWords(101);
        System.out.println(s);
    }
}
