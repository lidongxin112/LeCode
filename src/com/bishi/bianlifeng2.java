package com.bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 在便利蜂某门店中，有n种“蜂智选”商品，这些商品价格不一。在特殊时候，门店也会推出促销活动，
 * 以组合优惠的方式出售这些商品。
 * 比如，假设有3种商品：A、B、C，价格分别为 1、2、1，现在有套餐：2个A 、1个B、1个C，
 * 这个组合的优惠价格是4。
 * 而如果你的购物清单上有2个A、2个B、2个C，
 * 那么最划算的买法就是（1个套餐 + 单买一个B + 单买1个C）总价7。
 * 当然，像这样的优惠套餐可能不止一个。
 * 我们的目标是，根据给定的套餐和购物计划，找到花费最小的购买方案，输出总花费。
 * 数据范围
 * 1 <= n <= 10 0 < price[i] <= 10 0 <= purchase[i] <= 10 1 <= combine.length
 * <= 100 0 <= combine[i][j] <= 20   (j < n，套餐中各个商品的数量) 1 <= combine[i][j] <=
 * 300 (j = n，套餐价格)
 * 输入描述
 * 第1行：整数n，代表有n种“蜂智选”商品；
 * 第2行：输入一个数组price，数组长度为n，price[i]表示第i种“蜂智选”商品的价格，；
 * 第3行：输入一个数组purchase，数组长度为n，purchase[i]表示第i种蜂智选商品的采购量；
 * 第4行：输入一个整数m，代表有m种套餐；
 * 第5到m+5行：表示套餐数组combine[m][n+1]；m行数据表示有m种套餐，
 * 每行长度为 n + 1，每行的第 i 个数表示该套餐中第 i 种蜂智选商品的个数；特殊的：每一行的第
 * n+1 个（最后一个）数表示当前套餐的价格；
 * 请计算满足采购清单purchase所需花费的最低价格。 附：必须严格按照购物清单采购，不可多买/少买；
 * 输出描述
 * 输出一个最优结果：满足购物清单的最小花费。
 * 样例输入
 * 3
 * 1 2 3
 * 1 1 1
 * 1
 * 1 1 1 4
 * 样例输出
 * 4
 *
 * @author 东鑫
 */
public class bianlifeng2 {

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> price = new ArrayList<>();
        List<Integer> purchase = new ArrayList<>();
        List<List<Integer>> combine = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            price.add(sc.nextInt());
        }
        for (int j = 0; j < n; j++) {
            purchase.add(sc.nextInt());

        }
        int m = sc.nextInt();
        for (int i=0;i<m;i++){
            List<Integer> nums = new ArrayList<>();
            for (int j=0;j<=n;j++){
                nums.add(sc.nextInt());
            }
            combine.add(nums);
        }

        dfs(price,purchase,combine,0);
        System.out.println(min);
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> combine, List<Integer> purchase) {
        dfs(price,purchase,combine,0);
        return min;
    }
     static void dfs(List<Integer> price,List<Integer> purcharse,List<List<Integer>> combine ,int money){
        for (int i=0;i<combine.size();i++){
            List<Integer> list = combine.get(i);
            List<Integer> cur = new ArrayList<>();
            for (int j=0;j<list.size();j++){
                if (j== list.size()-1){
                    dfs(price,cur,combine,money + list.get(j));
                }else {
                    int num = purcharse.get(j);
                    if (num<list.get(j)){
                        break;
                    }
                    cur.add(num-list.get(j));
                }
            }
        }
        int m = money;
        for (int i=0;i<purcharse.size();i++){
            m += price.get(i) * purcharse.get(i);
        }
        min = Math.min(m,min);
    }
}
