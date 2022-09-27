package com.easy;

/**
 * @author 东鑫
 * 1518. 换酒问题
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * <p>
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * <p>
 * 请你计算 最多 能喝到多少瓶酒。
 */
public class lc1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int b = numBottles,n=numExchange;
        int ans = numBottles;
        while (b>=n){
            b-=n;
            ans++;
            b++;
        }
        return ans;
    }

    public int numWater(int x, int y, int z) {
        int num = 0;
        if (x==0){
            x +=1;
        }
        num += x + y / z;
        if (x < z && y < z && x + y <= z ) {
            return num;
        } else {
            boolean xy = x > z;
//            x =  xy  ? k : k + 1;
            y = x % z + y % z;
            x = x / z;
            return num + numWater(x, y, z);
        }
    }

    public static void main(String[] args) {
        int i = new lc1518().numWaterBottles(15, 8);
        System.out.println(i);
    }
}
