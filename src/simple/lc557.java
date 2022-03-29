package simple;

public class lc557 {
    public String reverseWords(String s) {
        String a = "";
        String [] ba = s.split(" ");
        StringBuilder c = new StringBuilder();
        int d  = ba.length;
        for (int i=0;i<d;i++){
            c = new StringBuilder(ba[i]);
            a += c.reverse();
            a+= " ";
        }
        System.out.println(a.length());
        a = a.substring(0,a.length()-1);
        a.trim();
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new lc557().reverseWords("Let's take LeetCode contest"));
    }
}
