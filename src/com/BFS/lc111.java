package com.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class lc111 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            for (int i=0;i<sz;i++){
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
    //

    /**
     *
     * @param args
     */
    /*

     */

    public static void main(String[] args) {

    }
}
