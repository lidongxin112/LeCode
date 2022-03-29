package com.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 */
public class lc752 {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (deads.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plu(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = min(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String plu(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j]== '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    public String min(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

    //    public void bfs(String target){
//        Queue<String> q = new LinkedList<>();
//        int a =1;
//        q.offer("0000");
//        while (!q.isEmpty()) {
//            int sz = q.size();
//            for (int i = 0; i < sz; i++) {
//
//                String cur = q.poll();
//                if (cur==target){
//                    System.out.println(cur);
//                    System.out.println(a);
//                    break;
//                }
//
//                for (int j = 0; j < 4; j++) {
//                    String up = plu(cur, j);
//                    String down = min(cur, j);
//                    q.offer(up);
//                    q.offer(down);
//                }
//            }
//        }
//        a++;
//    }
    /*
    双向BFS 需要知道重点位置
     */
    int openLock1(String[] a, String s) {
        Set<String> deads = new HashSet<>();
        for (String aa : a) {
            deads.add(aa);
        }
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(s);
        while (!q1.isEmpty() && !q2.isEmpty()) {

            //新建一个哈希集合，存储temp扩散结果
            Set<String> temp = new HashSet<>();
            if (q1.size() > q2.size()) {
                // 交换 q1 和 q2
                temp = q1;
                q1 = q2;
                q2 = temp;
            }
            for (String cur : q1) {
                if (deads.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    return step;
                }
                visited.add(cur);

                for (int j = 0; j < 4; j++) {
                    String up = plu(cur, j);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = min(cur, j);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return step;
    }


    public static void main(String[] args) {
        String[] dep = {"8888"};
        long l = System.currentTimeMillis();
        int i = new lc752().openLock(dep, "0009");
        System.out.println(i);
        System.out.println(System.currentTimeMillis() - i);
    }
    //1635390744693
    //1635390775435
    //1635391107401
}
