package com.bishi;

import java.util.Scanner;

/**
 * 聪明的老鼠
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 一只聪明的老鼠发现了一个三角形的奶酪迷宫。这个迷宫有若干个小房间，每个小房间有若干块大小相等的小奶酪（每个房间至少有一块奶酪）。 奶酪迷宫的构造如下： (1) 奶酪迷宫一共有N行，第1行有一个小房间，第2行有两个房间，第3行有三个小房间，......第N行有N个小房间。 (2) 所有的小房间都是从第1列开始进行排列的。 (3) 奶酪迷宫的入口是第1行的那个小房间。 (4) 由于奶酪迷宫的特殊构造，小老鼠进入一个房间后，不允许回退到上一层的房间，也不允许走到左边的房间，只允许走到右边或者下面的房间。 (5) 在奶酪迷宫的最后一层，每个房间都有一扇通往迷宫出口的门，且最后一层的小房间没有通往左边和右边小房间的门。 现在小老鼠已经知道了每个小房间里面有多少块小奶酪，它找到了一条可以从入口走到出口且可以得到最多小奶酪的路径。 你能不能编写一个程序，输出小老鼠最多可以得到多少块小奶酪呢？
 *
 *
 *
 * 输入描述
 * 单组输入。 第1行输入1个正整数N，表示奶酪迷宫的行数，N<=100。 接下来N行，第1行有1个正整数，表示第1行1个小房间的小奶酪数；第2行有2个正整数，表示第2行2个小房间的小奶酪数；......；第N行有N个正整数，表示第N行N个小房间的小奶酪数。每个房间的小奶酪数均不超过1000。每一行两个正整数之间用英文的空格隔开。
 *
 * 输出描述
 * 输出小老鼠最多可以得到的小奶酪的数量。
 *
 *
 * 样例输入
 * 3
 * 2
 * 4 5
 * 1 2 3
 * 样例输出
 * 13
 *
 */
public class jinshanyun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int [][] ab = new int [a][a];
        for (int i=0;i<a;i++){
            for (int j=0;j<a;j++){
                if (j>i){
                    ab[i][j] = 0;
                }
//                ab[i][j] = sc.nextInt();
                else {
                    ab[i][j] = sc.nextInt();
                }
            }
        }
        int i1 = maxHouse(ab);
        System.out.println(i1);

//        for (int i=0;i<a;i++){
//            for (int j=0;j<a;j++){
//                System.out.print(ab[i][j]);
//            }
//            System.out.println("");
//        }
    }
    public static int maxHouse(int[][] ab){
        int sum = 0;
        int ac=0;
        int bc=0;
        for (int i=0;i<ab.length-1;) {
            for (int j = 0; i < ab[0].length - 1; ) {
                sum += ab[i][j];
                if (i != ab.length - 1) {
                    if (ab[i][j + 1] > ab[i + 1][j]) {
                        j = j + 1;
                        bc = j;
                        continue;
                    } else {
                        i = i + 1;
                        ac = i;
                        continue;
                    }
                }
            }
        }
        sum+=ab[ac][bc];
        return sum;
    }
}
