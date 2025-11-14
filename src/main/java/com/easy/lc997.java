package com.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 东鑫
 * 997. 找到小镇的法官
 * 在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足条件 1 和条件 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
 */
public class lc997 {
    public int findJudge(int n, int[][] trust) {
        int [][] people = new int[n][2];
        for (int[] person:trust){
            int out = person[0];
            int in = person[1];
            people[out-1][0]++;
            people[in +1][1]++;

        }
        return 1;
    }

    public static void main(String[] args) {
        int n = 2;
        int [][] trust = {{1,3},{2,3},{3,1}};
        int judge = new lc997().findJudge(n, trust);
        System.out.println(judge);
    }
}
