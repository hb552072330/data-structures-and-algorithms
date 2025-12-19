package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-23 20:19
 **/
public class Top25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        ListNode dummary = new ListNode();
        //记录反转后最后节点
        ListNode last = dummary;
        //取到要反转的节点
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            ListNode next = curr.next;
            if (count % k == 0) {
                curr.next = null;
                //反转链表
                last.next = reverse(head);
                //抓住队尾节点
                last = head;
                //头节点指向新开始节点
                head = next;
                //队尾链接head
                last.next = head;
            }
            curr = next;
        }
        return dummary.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
