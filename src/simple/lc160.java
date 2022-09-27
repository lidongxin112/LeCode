package simple;

import java.util.HashSet;
import java.util.Set;

public class lc160 {
    //创建一个链表的类
    class ListNode {
        int val;    //数值 data
        ListNode next;    // 结点 node

        ListNode(int x) {    //可以定义一个有参构造方法，也可以定义一个无参构造方法
            val = x;
        }

        // 添加新的结点
        public void add(int newval) {
            ListNode newNode = new ListNode(newval);
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.add(newval);
            }
        }

        // 打印链表
        public void print() {
            System.out.print(this.val);
            if (this.next != null) {
                System.out.print("-->");
                this.next.print();
            }
        }
    }

    public ListNode getListNode(ListNode headA, ListNode headB) {
//      if (headA==null||headB==null) return null;
//      ListNode pA = headA,pB=headB;
//      while(pA!=pB){
//          pA = pA==null?headB:pa.next;
//          pb = pB==null?headA:pB.next;
//      }
//      return pA;
//
        Set<ListNode> visit = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visit.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visit.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
