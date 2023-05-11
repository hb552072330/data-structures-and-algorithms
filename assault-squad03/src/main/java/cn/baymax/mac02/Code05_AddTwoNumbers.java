package cn.baymax.mac02;

//https://leetcode.cn/problems/add-two-numbers/
//2
public class Code05_AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    //输出：[8,9,9,9,0,0,0,1]
    //输入：l1 = [2,4,3], l2 = [5,6,4]
    //输出：[7,0,8]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int count1 = 0, count2 = 0;
        while (cur1 != null) {
            count1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            count2++;
            cur2 = cur2.next;
        }
        cur1 = count1 > count2 ? l1 : l2;
        cur2 = cur1 == l1 ? l2 : l1;
        ListNode ans = cur1;
        ListNode pre = null;
        int carry = 0;
        while (cur2 != null) {
            int sum = cur1.val + cur2.val + carry;
            cur1.val = sum % 10;
            carry = sum / 10;
            pre = cur1;
            cur2 = cur2.next;
            cur1 = cur1.next;
        }
        while (cur1 != null && carry > 0) {
            int sum = cur1.val + carry;
            cur1.val = sum % 10;
            carry = sum / 10;
            pre = cur1;
            cur1 = cur1.next;
        }
        if (carry > 0) {
            ListNode next = new ListNode(carry);
            pre.next = next;
        }
        return ans;
    }
}
