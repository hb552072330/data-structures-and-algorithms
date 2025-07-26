package top100;

public class Top31SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode last = dummy;
        dummy.next = head;

        // 1 2 3 4

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode nextt = curr.next.next;

            ListNode next = curr.next;
            last.next = next;
            last = curr;
            //2->1
            next.next = curr;
            // 2 1 3 4
            curr.next = nextt;

            curr = nextt;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        swapPairs(l1);
    }
}
