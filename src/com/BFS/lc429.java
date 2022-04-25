package com.BFS;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class lc429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                Node poll = queue.poll();
                level.add(poll.val);
                for (Node child : poll.children) {
                    queue.offer(child);
                }
            }
            lists.add(level);
        }
        return lists;
    }

}
