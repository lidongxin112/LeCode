package com.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 东鑫
 */
public class lc911 {
    class TopVotedCandidate {
        List<Integer> tops;
        Map<Integer, Integer> voteCounts;
        int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            tops = new ArrayList<Integer>();
            voteCounts = new HashMap<Integer, Integer>();
            voteCounts.put(-1, -1);
            int top = -1;
            for (int i = 0; i < persons.length; ++i) {
                int p = persons[i];
                voteCounts.put(p, voteCounts.getOrDefault(p, 0) + 1);
                if (voteCounts.get(p) >= voteCounts.get(top)) {
                    top = p;
                }
                tops.add(top);
            }
            this.times = times;
        }

        public int q(int t) {
            int l = 0, r = times.length - 1;
            // 找到满足 times[l] <= t 的最大的 l
            while (l < r) {
                int m = l + (r - l + 1) / 2;
                if (times[m] <= t) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            return tops.get(l);
        }
    }
    }
    /**
     * 二分查找 找到相等或小于的所在times所在的地址 n
     * 先计算person中出现的议员的编号   遍历 n persons  用HashMap 统计议员获得票的数量 如果票数相等 返回最近获得投票的议员
     */
