package other;

import java.util.List;

/**
 * @Author zhanghongbing
 * @Date 2025-11-23 20:56
 **/
public class Top148 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode l1 = sortList(head, slow);
        ListNode l2 = sortList(slow, tail);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummary = new ListNode();
        ListNode curr = dummary;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        return dummary.next;
    }
}
