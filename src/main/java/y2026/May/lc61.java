package y2026.May;

/**
 * 61. 旋转链表
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 *
 *
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class lc61 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int n = 1;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        cur.next = head;
        k = n - k % n;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
    public static void main(String[] args) {
        ListNode node1 = new lc61().new ListNode(1);
        ListNode node2 = new lc61().new ListNode(2);
        ListNode node3 = new lc61().new ListNode(3);
        ListNode node4 = new lc61().new ListNode(4);
        ListNode node5 = new lc61().new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = new lc61().rotateRight(node1, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
