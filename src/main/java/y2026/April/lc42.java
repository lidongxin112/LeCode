package y2026.April;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 * 提示：
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class lc42 {
    public int trap1(int[] height) {
        int n = height.length;
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 1; i < n-1; i++) {
            int left = i-1;
            int right = n - 1;
            while (left < i || right > i) {
                if (left < i){
                    leftMax = Math.max(leftMax, height[left]);
                    left++;
                }
                if (right > i){
                    rightMax = Math.max(rightMax, height[right]);
                    right--;
                }
                if (rightMax == height[i]){
                    rightMax = 0;
                }
            }
            sum += Math.min(leftMax, rightMax) > height[i] ? Math.min(leftMax, rightMax) - height[i] : 0;
        }
        return sum;
    }
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;
        while (left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax){
                sum += leftMax - height[left];
                left++;
            }else {
                sum += rightMax - height[right];
                right--;
            }
            System.out.println( sum);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int [] height1 = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
        lc42 lc = new lc42();
//        System.out.println(lc.trap(height));
        System.out.println(lc.trap(height1));
    }
}
