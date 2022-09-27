package simple;

public class lc441 {
    public int arrangeCoins(int n) {
        long a = 100000007;
        long b = 0;
        for (long i = 1; i < a; i++) {
            long c = i * (i + 1) / 2;
            if (n > c) {
                continue;

            } else if (n == c ){
                b = i;
                break;
            }else {
                b = i  - 1;
                break;
            }

        }
        return (int) b;
    }

    public static void main(String[] args) {
        int i = new lc441().arrangeCoins(1804289383);
        System.out.println(i);
    }
}
