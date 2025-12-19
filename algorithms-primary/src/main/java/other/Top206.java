package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-18 21:59
 **/
public class Top206 {
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummary = new ListNode();
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = dummary.next;
            dummary.next = current;
            current = next;
        }
        return dummary.next;
    }


    public static class ListNode {
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
}
