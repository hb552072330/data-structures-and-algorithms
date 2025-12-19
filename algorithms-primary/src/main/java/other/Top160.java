package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-22 21:03
 **/
public class Top160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int aLen = 0;
        ListNode currA = headA;
        while (currA != null) {
            aLen++;
            currA = currA.next;
        }
        int bLen = 0;
        ListNode currB = headB;
        while (currB != null) {
            bLen++;
            currB = currB.next;
        }
        if (aLen < bLen) {
            currA = headB;
            currB = headA;
        } else {
            currA = headA;
            currB = headB;
        }
        int len = Math.abs(aLen - bLen);
        while (len > 0) {
            currA = currA.next;
            len--;
        }
        while (currA != null) {
            if (currA == currB) {
                return currB;
            } else {
                currA = currA.next;
                currB = currB.next;
            }
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.abs(2 - 3));
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l5.next = l3;

        ListNode headA = l1;
        ListNode headB = l5;
        new Top160().getIntersectionNode(headA, headB);
    }
}
