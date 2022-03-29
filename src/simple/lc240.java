package simple;

/**
 *240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 */
public class lc240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean boo = false;
        for (int i=0;i<n;i++){
            if (matrix[i][0]<=target&&target<=matrix[i][m-1]){
                boo = search(matrix[i], target);
                if (boo==true){
                    return true;
                }
            }else {
                continue;
            }
        }
//        for (int i=0;i<m;i++){
//            if (matrix[0][i]<=target&&target<=matrix[n-1][i]){
//                boo = search(matrix[i], target);
//            }else {
//                continue;
//            }
//        }
        return false;
    }
    public boolean search(int [] aa,int target){
        int a = 0;
        int b = aa.length-1;
        while (a<=b){
            int mid = (a + b) / 2;
            if (aa[mid]==target){
                return true;
            }else if(aa[mid]<target){
                a++;
            }else {
                b--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] aa = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean b = new lc240().searchMatrix(aa, 5);
        System.out.println(b);
    }
}
