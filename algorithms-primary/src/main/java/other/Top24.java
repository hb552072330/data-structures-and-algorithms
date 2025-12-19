package other;

import java.util.List;

/**
 * @Author zhanghongbing
 * @Date 2025-11-23 20:08
 **/
public class Top24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummary = new ListNode();
        ListNode curr = dummary;
        while (head != null && head.next != null) {
            //下一节点
            ListNode next = head.next;
            //下一个反转节点
            ListNode nextt = head.next.next;
            //当前节点的下一节点指向反转的节点
            curr.next = next;
            next.next = head;
            //当前节点指向反转后的节点
            curr = head;
            head = nextt;
            curr.next = head;
        }
        return dummary.next;
    }
}
