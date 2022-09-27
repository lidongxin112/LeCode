package com.BFS;

import java.util.*;

/**
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * 假设我们需要调查从基因序列start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使start 变化为 end
 * 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 * 注意：起始基因序列start 默认是有效的，但是它并不一定会出现在基因库中。
 *
 * @author 东鑫
 */
public class lc433 {
    static char[] items = new char[]{'A', 'C', 'G', 'T'};
    String S,T;
    Set<String> set = new HashSet<>();

    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        Deque<String> d = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        d.addLast(start);
        map.put(start, 0);
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                String s = d.pollFirst();
                char[] cs = s.toCharArray();
                int step = map.get(s);
                for (int i = 0; i < 8; i++) {
                    for (char c : items) {
                        if (cs[i] == c) {
                            continue;
                        }
                        char[] clone = cs.clone();
                        clone[i] = c;
                        String sub = String.valueOf(clone);
                        if (!set.contains(sub)) {
                            continue;
                        }
                        if (map.containsKey(sub)) {
                            continue;
                        }
                        if (sub.equals(end)) {
                            return step + 1;
                        }
                        map.put(sub, step + 1);
                        d.addLast(sub);
                    }
                }

            }
        }
        return -1;
    }
    //双向BFS
    public int minMutation2(String start, String end, String[] bank) {
        S = start; T = end;
        for (String s : bank) {
            set.add(s);
        }
        return bfs();
    }
    int bfs() {
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        d1.addLast(S); m1.put(S, 0);
        d2.addLast(T); m2.put(T, 0);
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            if (d1.size() <= d2.size()) {
                t = update(d1, m1, m2);
            } else {
                t = update(d2, m2, m1);
            }
            if (t != -1) {
                return t;
            }
        }
        return -1;
    }
    int update(Deque<String> d, Map<String, Integer> cur, Map<String, Integer> other) {
        int size = d.size();
        while (size-- > 0) {
            String s = d.pollFirst();
            char[] cs = s.toCharArray();
            int step = cur.get(s);
            for (int i = 0; i < 8; i++) {
                for (char c : items) {
                    if (cs[i] == c) {
                        continue;
                    }
                    char[] clone = cs.clone();
                    clone[i] = c;
                    String sub = String.valueOf(clone);
                    if (!set.contains(sub)) {
                        continue;
                    }
                    if (other.containsKey(sub)) return step + 1 + other.get(sub);
                    if (!cur.containsKey(sub) || cur.get(sub) > step + 1) {
                        cur.put(sub, step + 1);
                        d.addLast(sub);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] s = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        int i = new lc433().minMutation("AACCGGTT", "AAACGGTA", s);
        System.out.println(i);
    }
}
