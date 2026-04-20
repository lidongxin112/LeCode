package y2026.April;

public class NodeList {

    class ListNode{
        int val;
        ListNode next;
        ListNode(){
            this.val = 0;
        }
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode isPar(ListNode a,ListNode b){
        ListNode c = null;
            while (a.next !=  null){
                a = a.next;
                while (b.next != null){
                    if (a.equals(b)){
                        c = a;
                    }
                    b = b.next;
                }
            }
            return c;
    }
}
