package y2026.May;

/**
 * 206. 反转链表
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 */
public class lc260 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseList(ListNode head) {
          ListNode pre = null;
          ListNode cur = head;
          while (cur != null){
              ListNode next = cur.next;
              cur.next = pre;
              pre = cur;
              cur = next;
          }
          return pre;
    }
    public ListNode reverseList1(ListNode head) {
          if (head == null || head.next == null) {
              return head;
          }
          ListNode newHead = reverseList1(head.next);
          head.next.next = head;
          head.next = null;
          return newHead;
    }


}
