package simple;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class lc74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean boo = false;
        for (int i=0;i<n;i++){
            if (matrix[i][0]<=target&&target<=matrix[i][m-1]){
                 boo = search(matrix[i], target);
            }else {
                continue;
            }
        }
        return boo;
    }
    public boolean search(int[] a,int target){
        int n = a.length -1;
        int m = 0;
        while (m<=n){
            int mid = (n + m) / 2;
            if (a[mid]==target){
                return true;
            }else if (a[mid]<target){
                m++;
            }else {
                n--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] aa = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean b = new lc74().searchMatrix(aa, 3);
        System.out.println(b);
    }
}
