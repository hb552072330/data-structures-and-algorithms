package class04;


/**
 * @author zhanghongbing
 * @data 2022/9/2
 * 25
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

    //运行成功: 测试用例:[1,2,3,4,5] 2 测试结果:[2,4,5] 期望结果:[2,1,4,3,5] stdout:

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroup(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverseGroup(start, end);
        ListNode endLast = start;
        while (endLast.next != null) {
            start = endLast.next;
            end = getKGroup(start, k);
            if (end == null) {
                return head;
            }
            reverseGroup(start, end);
            endLast.next = end;
            endLast = start;
        }
        return head;
    }

    private void reverseGroup(ListNode start, ListNode end) {
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
