package simple;

import java.util.HashMap;
import java.util.Map;

public class lc138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }


    /*
    使用hashmap来存储旧结点和新节点的映射
    空间复杂度O(n) n为链表的长度
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node node = head;
        Map<Node, Node> cachNode = new HashMap<Node, Node>();
        while (node != null) {
            Node clone = new Node(node.val, null, null);
            cachNode.put(node, clone);
            node = node.next;
        }
        node = head;
        while (node!=null) {
            cachNode.get(node).next = cachNode.get(node.next);
            cachNode.get(node).random = cachNode.get(node.random);
        }
        return cachNode.get(head);

    }
    }
