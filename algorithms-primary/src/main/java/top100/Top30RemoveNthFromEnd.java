package top100;

public class Top30RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return head;
        }
        ListNode curr = head;
//        ListNode first = new ListNode();
//        first.next = head;
        //[1] 1
        // cur = null
        //[2,2] 2
        while (n > 0 && curr != null) {
            curr = curr.next;
            n--;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        while (curr != null) {
            curr = curr.next;
            pre = pre.next;
        }
        if (pre != null && pre.next != null) {
            curr = pre.next.next;
            pre.next = curr;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        removeNthFromEnd(new ListNode(1), 1);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;

        removeNthFromEnd(l1, 2);
    }
}
