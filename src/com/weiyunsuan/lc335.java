package com.weiyunsuan;

/**
 * 335. 路径交叉
 * 给你一个整数数组 distance 。
 *
 * 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 *
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
 */
public class lc335 {
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        for (int i=3;i<n;i++){
            if (distance[i]>=distance[i-2]&&distance[i-1]<=distance[i-3]){
                return true;
            }
            if (i==4&distance[3]==distance[1]&&distance[4]>=distance[2]-distance[0]){
                return true;
            }
            if (i>5&&distance[i-3]-distance[i-5]<=distance[i-1]
                    &&distance[i-1]<=distance[i-3]
                    &&distance[i]>=distance[i-2]-distance[i-4]
                    &&distance[i-2]>distance[i-4]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int [] aa = {1,2,2,3,4};

        boolean selfCrossing = new lc335().isSelfCrossing(aa);
        System.out.println(selfCrossing);
    }
}
