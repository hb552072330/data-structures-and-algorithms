package top100;

public class Top24reverseList {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode ans = null;
//        ListNode next = head.next;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = ans;
            ans = curr;
            curr = next;

        }
        return ans;
    }

}
