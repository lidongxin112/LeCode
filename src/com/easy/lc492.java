package com.easy;

/**
 * 492. 构造矩形
 * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 * <p>
 * 1. 你设计的矩形页面必须等于给定的目标面积。
 * <p>
 * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
 * <p>
 * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。
 */
public class lc492 {
    public int[] constructRectangle(int area) {
        int[] aa = new int[2];
        for (int i = 1; i <= Math.sqrt(area); i++) {
            int a = i; //宽度
            if (area % i == 0) {
                int b = area / i; //长度
                if (a <= b) {
                    aa[0] = b;
                    aa[1] = a;
                    if (area % (i+1) ==0){
                        continue;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }

        return aa;
    }


    public static void main(String[] args) {
        int[] ints = new lc492().constructRectangle(4);
        for (int i : ints) {
            System.out.println(i);
        }

    }
}
