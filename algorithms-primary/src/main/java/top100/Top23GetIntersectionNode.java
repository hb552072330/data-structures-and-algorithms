package top100;

public class Top23GetIntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//        ListNode p = headA;
//        ListNode q = headB;
//        while (p != q) {
//            p = p != null ? p.next : headB;
//            q = q != null ? q.next : headA;
//        }
//        return p;
        /**


         */

        //a2.next = b3.next;

        if (headA == null || headB == null) {
            return null;
        }
        int aLen = 0, bLen = 0;
        ListNode currentNode = headA;
        while (currentNode != null) {
            currentNode = currentNode.next;
            aLen++;
        }
        currentNode = headB;
        while (currentNode != null) {
            currentNode = currentNode.next;
            bLen++;
        }
        ListNode ans = null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (aLen >= 0 && curA != null) {
            if (aLen > bLen) {
                curA = curA.next;
                aLen--;
            } else if (aLen < bLen) {
                curB = curB.next;
                bLen--;
            } else {
                if (curA == curB) {
                    ans = curA;
                    break;
                }
                curA = curA.next;
                curB = curB.next;

                aLen--;
                bLen--;

            }
        }
        return ans;
    }


//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }

    public static void main(String[] args) {
//        [4,1,8,4,5]
//			[5,6,1,8,4,5]
        int[] a = {};
        int[] b = {};
        ListNode A = new ListNode(4);
        ListNode B = new ListNode(5);
        ListNode n1 = new ListNode(1);
        ListNode n6 = new ListNode(6);
        ListNode n8 = new ListNode(8);

        A.next = n1;
        B.next = n6;
//        n6.next = n1;
//        n1.next = n8;
        System.out.println(getIntersectionNode(A, B));
        ListNode listNode = new ListNode(1);
        System.out.println(getIntersectionNode(listNode, listNode));
    }
}
