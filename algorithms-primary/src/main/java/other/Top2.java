package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-23 19:42
 **/
public class Top2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummary = new ListNode();
        ListNode current = dummary;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            current.next = new ListNode(carry);
        }


        return dummary.next;
    }
}
