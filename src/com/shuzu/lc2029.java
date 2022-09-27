package com.shuzu;

/**
 * @author 东鑫
 */
public class lc2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] ans = new int[3];
        boolean br = false;
        for (int i : stones) {
            ans[i % 3]++;
        }
        //为3的数量
        if (ans[0] % 2 == 0) {
            //ans[1] ans[2] 同时不为0为true 有一个为0为false
            return ans[1] != 0 && ans[2] != 0;
        }
        //
        return ans[2] > ans[1] + 2 || ans[1] > ans[2] + 2;

//        System.out.println(ans[1] == ans[2]);
//        if ((ans[0] + ans[1] + ans[2]) % 2 == 0 && (ans[1] == 0 || ans[2] == 0)) {
//            br = ans[1] == ans[2] ? true : false;
//        } else {
//            br = ans[1] == ans[2] ? false : true;
//        }
//        if (ans[1] != ans[2]) {
//            return false;
//        }
//        return br;
    }

    public static void main(String[] args) {
        int[] stones = {2,1,3};
        boolean b = new lc2029().stoneGameIX(stones);
        System.out.println(b);

        System.out.println(2 % 3);
        System.out.println(1 % 3);
    }
}
