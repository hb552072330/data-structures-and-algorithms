package top100;

public class Top29AddTwoNumbers {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = new ListNode();
        ListNode curr = ans;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            curr = curr.next = new ListNode(carry % 10);
            carry /= 10;

        }
        return ans.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = new ListNode();
        ListNode curr = ans;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            l1.val = sum % 10;
            curr.next = l1;
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;

        }
        curr.next = l1 == null ? l2 : l1;
        //有进位
        while (carry != 0) {
            if (curr.next == null) {
                curr.next = new ListNode(carry);
                break;
            }
            curr = curr.next;
            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;
        }
        return ans.next;
    }
}
