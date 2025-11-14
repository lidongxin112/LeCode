package com.sheji;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 东鑫
 */
public class lc933 {
    public Queue<Integer> q;

    public lc933() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.offer(t);
        while(q.peek()< t -3000){
            q.poll();
        }
        return q.size();
    }

    public static void main(String[] args) {

    }
}
