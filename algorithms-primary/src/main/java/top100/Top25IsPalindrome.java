package top100;

public class Top25IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode mid = middleNode(head);
        ListNode head2 = reverseList(mid);
        while (head2 != null) {
            ;
            if (head.val != head2.val) {
                return false;
            }
            head2 = head2.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode mid) {
        ListNode pre = null;
        ListNode current = mid;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;

        }
        return pre;
    }

    private ListNode middleNode(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        boolean palindrome = new Top25IsPalindrome().isPalindrome(l1);
        System.out.println(palindrome);

    }
}
