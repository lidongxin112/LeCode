package simple;

/**
 * 3的幂
 */
public class lc326 {
    public boolean isPowerOfThree(int n) {
        if(n==1||n==3){
            return true;
        }else {
            int aa = is(n);
            if (aa==3){
                return true;
            }
        }
        return false;
    }
    public static int is(int n) {
        if (n % 3 == 0) {
            int m = n / 3;
            if (m == 3) {
                return 3;
            } else if (0 <= m && m < 3) {
                return -1;
            } else {
                return is(m);
            }
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        boolean powerOfThree = new lc326().isPowerOfThree(77);
        System.out.println(powerOfThree);
    }
}
