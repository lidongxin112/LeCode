package com.dynamicProgramming;

/**
 * 458. 可怜的小猪
 * 有 buckets 桶液体，其中 正好 有一桶含有毒药，其余装的都是水。它们从外观看起来都一样。为了弄清楚哪只水桶含有毒药，你可以喂一些猪喝，通过观察猪是否会死进行判断。不幸的是，你只有 minutesToTest 分钟时间来确定哪桶液体是有毒的。
 * <p>
 * 喂猪的规则如下：
 * <p>
 * 选择若干活猪进行喂养
 * 可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。
 * 小猪喝完水后，必须有 minutesToDie 分钟的冷却时间。在这段时间里，你只能观察，而不允许继续喂猪。
 * 过了 minutesToDie 分钟后，所有喝到毒药的猪都会死去，其他所有猪都会活下来。
 * 重复这一过程，直到时间用完。
 *
 * @author 东鑫
 */
public class lc458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) {
            return 0;
        }
        int[][] combinations = new int[buckets + 1][buckets + 1];
        combinations[0][0] = 1;
        int iterations = minutesToTest / minutesToDie;
        int[][] f = new int[buckets][iterations + 1];
        for (int i = 0; i < buckets; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j <= iterations; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < buckets; i++) {
            combinations[i][0] = 1;
            combinations[i][i] = 1;
            for (int j = 1; j < i; j++) {
                combinations[i][j] = combinations[i - 1][j - 1] + combinations[i - 1][j];
            }
            for (int j = 1; j <= iterations; j++) {
                for (int k = 0; k <= i; k++) {
                    f[i][j] += f[k][j - 1] * combinations[i][i - k];
                }
            }
            if (f[i][iterations] >= buckets) {
                return i;
            }
        }
        return 0;
    }
}
/*
test / Die = n  最大轮数
至少需要多少只 能在n次中找到有毒的水
用f(i,j) 表示 i只小猪 测试j轮 确定最大轮数 计算f(i,n)>=buckets 使i最小
如果测试轮数为0 或者小猪数为0不能测试
只有一桶不需要 对任意i  都有   f(i,0) = 1;
f(0,j) = 1
当 i,j>0时
递推计算    f(i,j) 的值
当一轮测试后 有k个小猪存活，所剩轮数为n-1
此时最大桶数为 f(k,n-1)   i只小猪存活的组合数为c(i,k)
此时最大的桶数为f(k,n-1) * c(i,k)
由于0<=k<=i
f(i,j)=
k=0
∑
i    f(k,j−1)×C(i,k)
c(0,0) = 1
c(i,0) = c(i,i) = 1
i<0<k
当c(i,j) = c(i-1,j-1) + c(i-1,j)
当小猪数量等于buckets - 1，可以把buckets - 1给每只小猪喝一桶
如果小猪都存活 剩下的那一桶有毒，有死了的小猪证明它喝的那一桶有毒
可以在一轮内确定有毒的是那一桶
0<=i<buckets
0<=j<=n
为了计算f的值 先预计算 组合的值
当buckets为1
小猪为0
 */