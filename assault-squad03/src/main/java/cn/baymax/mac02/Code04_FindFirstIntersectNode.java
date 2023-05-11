package cn.baymax.mac02;

public class Code04_FindFirstIntersectNode {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode getIntersectNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode loopNode1 = getLoopNode(headA);
        ListNode loopNode2 = getLoopNode(headB);
        if (loopNode2 == null && loopNode1 == null) {
            return getIntersectionNode(headA, headB);
        }
        if (loopNode2 != null && loopNode1 != null) {
            return getIntersectionCycleNode(headA, loopNode1, headB, loopNode2);
        }
        return null;
    }

    private ListNode getIntersectionCycleNode(ListNode headA, ListNode loopNode1, ListNode headB, ListNode loopNode2) {
        ListNode ans = null;
        ListNode cur1 = null;
        ListNode cur2 = null;
        if (loopNode1 == loopNode2) {
            int n = 0;
            cur1 = headA;
            while (cur1 != loopNode1) {
                n++;
                cur1 = cur1.next;
            }
            cur2 = headB;
            while (cur2 != loopNode1) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? headA : headB;
            cur2 = cur1 == headA ? headB : headA;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur2 = cur2.next;
                cur1 = cur1.next;
            }
            return cur1;
        } else {//相交点在环上
            cur1 = loopNode1.next;
            while (cur1 != loopNode1) {
                if (cur1 == loopNode2) {
                    return loopNode1;
                }
                cur1 = cur1.next;
            }
            return cur1;
        }
    }

    /**
     * 获取当前链表环的点
     *
     * @param head
     * @return
     */
    private ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode quick = head.next.next;
        while (slow != quick) {
            if (quick.next == null || quick.next.next == null) {
                return null;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 无环单链表，相交点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int n = 0;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1.next != null) {
//            if (cur1.next == null) {
//                break;
//            }
            cur1 = cur1.next;
            n++;
        }
        while (cur2.next != null) {
//            if (cur2.next == null) {
//                break;
//            }
            cur2 = cur2.next;
            n--;
        }
        if (cur2 != cur1) {
            return null;
        }
        cur1 = n > 0 ? headA : headB;
        cur2 = cur1 == headA ? headB : headA;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


    /**
     * 判断当期链表是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode quick = head.next.next;
        ListNode slow = head.next;
        while (quick != null && slow != null) {
            if (quick == slow) {
                return true;
            }
            slow = slow.next;
            quick = quick.next;
            if (quick == null) {
                return false;
            }
            quick = quick.next;
        }
        return false;
    }

}
