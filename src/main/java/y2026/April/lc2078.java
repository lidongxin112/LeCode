package y2026.April;

public class lc2078 {
    public int maxDistance(int[] colors) {
        int sum = 0;
        for (int i = 0; i < colors.length; i++){
            for (int j = i + 1; j < colors.length; j++){
                if (colors[i] != colors[j]){
                   sum =  Math.max(j - i,sum);
                }
            }
        }
        return sum;
    }
    public int maxDistance1(int []  colors){
        int n = colors.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = n - 1;
            while (left < right) {
                if (colors[left] != colors[right]) {
                    sum = Math.max(sum, right - left);
                }
                right--;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] colors = {1,1,1,6,1,1,1};
        lc2078 lc = new lc2078();
        System.out.println(lc.maxDistance1(colors));
    }
}
