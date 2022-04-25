package com.bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 最少打印几张发票
 * Description
 *
 * 四达时代在非洲部分国家开展广播电视运营服务，针对非洲人民的消费习惯，对同一个节目包都会提供不同规格的购买套餐。假定全部节目
 *
 * 包的不同规格套餐的每日资费相同，均为每日1元。当某个用户来四达营业厅购买节目包套餐时，每购买一个套餐需要打印一张发票，因此
 *
 * 当用户购买多个套餐时，为了节约打印发票时间，需要计算最少的套餐个数。
 *
 *
 *
 * 例如一个节目包，有1日，2日和5日三种规格，则该节目的套餐价格列表为 1,2,5。用户缴纳了11元现金，最少需要购买2个5日包和1个1日包，一共需要打印3张发票。
 *
 * 例如一个节目包，只有1日规格，则该节目的套餐价格列表为 1。用户缴纳了10元现金，最少需要购买10个1日包，一共需要打印10张发票。
 *
 * 例如有一个节目包，有1日，9日和10日三种规格，则该节目包的套餐价格列表为1,9,10。用户缴纳了18元现金，最少需要购买2个9日包，一共需要打印2张发票。
 *
 *
 * Input
 * 输入顺序为：package  amount，package为不同规格的套餐资费，默认输入至少提供1日资费1元，package使用英文逗号分隔。amount为用户准备购买节目套餐的现金。package和amount之间使用1位空格表示
 * @author 东鑫
 */
public class avb {
        static int max = Integer.MIN_VALUE;
        public static int maximalSideOfSquare(char[][] matrix) {
            // TODO show me your code
            int max = Integer.MIN_VALUE;
            if(matrix==null){
                return 0;
            }
            int m = matrix.length,n = matrix[0].length;
            for(int i=0;i<m;i++){
                matrix[i][0] = 'U';
                matrix[i][n-1] = 'U';
            }
            for(int j=0;j<n;j++){
                matrix[0][j] = 'U';
                matrix[m-1][j] = 'U';
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    max = Math.max(dfs(matrix,i,j,0),max);
                }
            }
            return max;
        }
        public static int dfs(char[][] matrix,int i,int j,int k){
            int m = matrix.length,n = matrix[0].length;
            int ma = k;
            if( i < 0 || i > m && j < 0 || j > n){
                return 0;
            }
            if(matrix[i][j] == 'U'){
                return 0;
            }
            max = Math.max(ma,max);
            for(int aa=0;aa < 4;aa++){
                dfs(matrix,i + 1,j,k);
                dfs(matrix,i -1,j,k);
                dfs(matrix,i,j + 1,k);
                dfs(matrix,i,j - 1,k);
            }
            return max;
        }
        // 自测用
        public static void main(String[] args) {
            char [][] a = {{'R','U','R','U','U'},
                    {'R','U','R','R','R'},
                    {'R','R','R','R','R'},
                    {'R','U','U','R','U'}};
            System.out.println(maximalSideOfSquare(a));
        }
}
