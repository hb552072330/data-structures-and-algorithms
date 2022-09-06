package class04;


/**
 * @author zhanghongbing
 * @data 2022/9/2
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */
public class Code04ReverseNodesInKGroup2 {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroup(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverseGrop(start, end);
        ListNode endLast = start;
        while (endLast.next != null) {
            start = endLast.next;
            end = getKGroup(start, k);
            if (end == null) {
                return head;
            }
            reverseGrop(start, end);
            endLast.next = end;
            endLast = start;
        }
        return head;
    }

    private void reverseGrop(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    private ListNode getKGroup(ListNode head, int k) {
        while (--k > 0 && head != null) {
            head = head.next;
        }
        return head;
    }


}
