package class04;


/**
 * @author zhanghongbing
 * @data 2022/9/2
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */
public class Code04ReverseNodesInKGroup {
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
        //如果end为空不满足反转数量
        if (end == null) {
            return head;
        }
        //反转数据
        reverse(start, end);
        head = end;
        ListNode lastEnd = start;//1
        //如果还有后续节点继续循环 2 1 3 4 5
        while (lastEnd.next != null) {
            start = lastEnd.next;//3
            end = getKGroup(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);//2 1 4 3 5
            lastEnd.next = end;//1->4 连接
            lastEnd = start;//3
        }
        return head;
    }

    private void reverse(ListNode start, ListNode end) {
        end = end.next;
        //当前节点
        ListNode current = start;
        ListNode pre = null;
        ListNode next = null;
        while (current != end) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        start.next = end;
    }

    private ListNode getKGroup(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }


}
