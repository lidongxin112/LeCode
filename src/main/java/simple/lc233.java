package simple;

public class lc233 {
    /*
    i 为 n 代表个位或...位的个数
    通用格式

     */
    public int countDigitOne(int n) {
        int an = 0;
        for (int i = 1; i < n; i = i * 10) {
            int a = n / i, b = n % i;
            an += (a + 8) / 10 * i + bbb(a) * (b + 1);
        }
        return an;
    }

    public static int bbb(int c) {
        if (c % 10 == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new lc233().countDigitOne(13));
    }
}
