package com.DFS;

/**
 * 563. 二叉树的坡度
 * 给定一个二叉树，计算 整个树 的坡度 。
 *
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 *
 * 整个树 的坡度就是其所有节点的坡度之和。
 * @author 东鑫
 */
public class lc563 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int findTilt(TreeNode root) {
              if (root==null){
                  return 0;
              }
              return Math.abs(sum(root.left)-sum(root.right)) + findTilt(root.left) + findTilt(root.right);
        }
        public int sum(TreeNode node){
              if (node==null){
                  return 0;
              }
              return node.val+sum(node.left) + sum(node.right);
          }

    public static void main(String[] args) {
    }

}
