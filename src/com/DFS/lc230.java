package com.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 */
public class lc230 {
    class TreeNode {
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
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> kth = kth(root);
            Integer[] a = (Integer[]) kth.toArray();
            Arrays.stream(a).sorted();
            return a[k];
        }
        public List<Integer> kth(TreeNode root){
            List<Integer> list = new ArrayList<>();
            if (root==null){
                return null;
            }
            int val = root.val;
            list.add(val);
            kth(root.left);
            kth(root.right);
            return list;
        }
    }


}
