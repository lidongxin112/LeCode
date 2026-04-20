package y2026.April;

public class lc3783 {
    public int mirrorDistance(int n) {
        int a = n,c = n;
        int sum = 0;
        int count = 0;
        while (a != 0){
            a /= 10;
            count++;
        }
        for (int i = count - 1; i >= 0; i--) {
            int temp = n % 10;
            sum += temp * Math.pow(10, i);
            n /= 10;
        }
        return Math.abs(sum - c);
    }
    public static void main(String[] args) {
        lc3783 lc3783 = new lc3783();
        int mirrorDistance = lc3783.mirrorDistance(10);
        System.out.println(mirrorDistance);
    }

}
