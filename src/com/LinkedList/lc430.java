package com.LinkedList;

import java.util.Stack;

/**
 * @author 东鑫
 * 430. 扁平化多级双向链表
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，
 * 可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，
 * 如下面的示例所示。
 * <p>
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 */
public class lc430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }
    Node dfs(Node head) {
        Node last = head;
        while (head != null) {
            if (head.child == null) {
                last = head;
                head = head.next;
            } else {
                Node tmp = head.next;
                Node childLast = dfs(head.child);
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                if (childLast != null) {
                    childLast.next = tmp;
                }
                if (tmp != null) {
                    tmp.prev = childLast;
                }
                last = head;
                head = childLast;
            }
        }
        return last;
    }


}
