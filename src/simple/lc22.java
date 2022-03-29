package simple;

public class lc22 {

//     * Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

        public ListNode getKthFromEnd(ListNode head, int k) {
          ListNode fast = head;
          ListNode slow = head;
          while (fast != null && k>0){
              fast = fast.next;
              k--;
          }
          while(fast!=null){
              fast = fast.next;
              slow = slow.next;
          }
          return slow;
        }
}
