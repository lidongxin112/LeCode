package com.LinkedList;

import java.util.Random;

/**
 * @author 东鑫
 */
public class lc382 {
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

    ListNode head;
    Random r = new Random();

    public lc382(ListNode head) {
        this.head = head;
    }


    public int getRandom() {
        int i = 0, res = 0;
        ListNode p = head;
        while (p!=null){
            i++;
            if (0==r.nextInt(i)){
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
