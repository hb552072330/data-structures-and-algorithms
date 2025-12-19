package other;

import top100.ListNode;
import top100.Top25IsPalindrome;

/**
 * @Author zhanghongbing
 * @Date 2025-11-22 21:35
 **/
public class Top234 {
    public boolean isPalindrome(ListNode head) {
        boolean ans = true;
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode end = reverse(slow);
        while (end != null) {
            if (end.val != head.val) {
                return false;
            }
            end = end.next;
            head = head.next;
        }
        return ans;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
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
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        boolean palindrome = new Top234().isPalindrome(l1);
        System.out.println(palindrome);

    }
}

