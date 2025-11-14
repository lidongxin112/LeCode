package com.bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在跨年这一天，便利蜂的商店推出了满减活动，当你打开便利蜂APP进行支付时，你有一张满 Y 元减20 元的优惠券，
 * 商店里总共有 n 种商品，第 i 种商品一件商品需要 Ai元，
 * 因为满减活动限制，所以每种商品你最多只能购买一份，如果你想使用这张优惠卷最少需要购买多少元的商品。
 * 输入描述
 * 第一行两个正整数n和Y，分别表示可供购买的商品数量和优惠券的最低使用总价。 接下来一行n个整数，
 * 第i个整数表示第i种商品的价格。[每个数之间用空格隔开]
 * 数据范围：
 * 1 <= n <= 200
 * 0< Ai  <= 100
 * 1 <= Y <= 10000
 * 输出描述
 * 共一行，1 个数，表示要使用这张满 Y 元减20 元的优惠券最少需要购买多少元的商品,保证有解。
 * 样例输入
 * 4 30
 * 18 20 22 21
 * 样例输出
 * 38
 * 提示
 * 样例 2：
 * 输入：
 * 6 70
 * 25 34 33 46 49 31
 * 输出：
 * 71
 */
public class bianlifeng3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = sc.nextInt();
        int [] price = new int[n];
        for (int i=0;i<n;i++){
            price[i] = sc.nextInt();
        }
        Arrays.sort(price);
        int min = Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (price[i]>y){
                    min = Math.min(min,price[i] + price[j]);
                }
                if (price[i] + price[j] > y){
                    min = Math.min(min,price[i] + price[j]);
                }
                if (price[j]>y){
                    min = Math.min(min,price[i] + price[j]);
                }
            }
        }
        System.out.println(min);
    }
}
