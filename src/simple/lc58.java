package simple;

/**
 * 最后一个单词的长度
 */
public class lc58 {
    public int lengthOfLastWord(String s) {
        String [] a = s.split(" ");
        int n = a.length;
        return a[n-1].length();
    }

    public static void main(String[] args) {
        String s = "Hello World";
        int l = new lc58().lengthOfLastWord(s);
        System.out.println(l);
    }
}
