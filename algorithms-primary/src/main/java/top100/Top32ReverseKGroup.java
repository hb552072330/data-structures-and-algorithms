package top100;

public class Top32ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode curr = head;
        ListNode reverseCurr = dummy;
        while (curr != null) {
            ListNode listNode = reverseK(curr, k, reverseCurr);
            reverseCurr = listNode;
            if(curr == listNode.next){
                break;
            }
            curr = listNode.next;
        }

        return dummy.next;
    }

    private static ListNode reverseK(ListNode head, int k, ListNode reverseCurr) {
        int count = 0;
        ListNode curr = head;
        while (curr != null && count < k) {
            count++;
            curr = curr.next;
        }
        if (count == k) {
            ListNode current = head;
            ListNode ans = null;
            while (k > 0) {
                ListNode next = current.next;
                current.next = ans;
                ans = current;
                current = next;
                k--;
            }
            reverseCurr.next = ans;
            reverseCurr = head;
            reverseCurr.next = curr;
        } else {
            reverseCurr.next = head;
        }
        return reverseCurr;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = reverseKGroup(l1, 3);
        System.out.println(listNode);
    }

}
