package class04;

/**
 * @author zhanghongbing
 * @data 2022/9/2
 * 2
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class Code05AddTwoNumbers {
    public class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getListNodeLength(l1);
        int len2 = getListNodeLength(l2);
        ListNode l = len1 > len2 ? l1 : l2;
        ListNode s = l == l2 ? l1 : l2;
        ListNode curL = l;
        ListNode curS = s;
        int carry = 0;
        int curNum = 0;
        ListNode last = null;
        while (curS != null) {
            last = curL;
            curNum = curS.val + curL.val + carry;
            carry = curNum / 10;
            curL.val = curNum % 10;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            last = curL;
            curNum = curL.val + carry;
            carry = curNum / 10;
            curL.val = curNum % 10;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return l;
    }

    private int getListNodeLength(ListNode l1) {
        int ans = 0;
        while (l1 != null) {
            l1 = l1.next;
            ans++;
        }
        return ans;
    }
}
