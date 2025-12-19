package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-23 19:51
 **/
public class Top19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1 2 3 4 5   n=2
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode dummary = new ListNode();
        dummary.next = head;
        ListNode slow = dummary;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummary.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        new Top19().removeNthFromEnd(l1, 1);

    }
}
