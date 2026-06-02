package y2026.May;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class lc94 {
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
    public List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> list = new ArrayList<>();

          if (root==null){
              return list;
          }
          list.addAll(inorderTraversal(root.left));
          list.add(root.val);
          list.addAll(inorderTraversal(root.right));
          return list;
    }

    public static void main(String[] args) {
          lc94 lc94 = new lc94();
          System.out.println(lc94.inorderTraversal(new lc94().new TreeNode(1, null, new lc94().new TreeNode(2, new lc94().new TreeNode(3), null))));
          System.out.println(lc94.inorderTraversal(new lc94().new TreeNode()));
          System.out.println(lc94.inorderTraversal(new lc94().new TreeNode(1)));
    }
}
