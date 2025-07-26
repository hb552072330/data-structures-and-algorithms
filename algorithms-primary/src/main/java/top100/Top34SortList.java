package top100;

import java.util.List;

public class Top34SortList {
    public ListNode sortList(ListNode head) {
        //归并排序，不用递归
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        ListNode first = head;
        ListNode ans = head;
        ListNode pre = null;
        for (int len = 1; len < length; len <<= 1) {
            while (first != null) {
                ListNode[] lhtrht = lhtrht(first, len);
                ListNode[] ht = merge(lhtrht[0], lhtrht[1], lhtrht[2], lhtrht[3]);
                if (ans == first) {
                    ans = ht[0];
                    pre = ht[1];
                } else {
                    pre.next = ht[0];
                    pre = ht[1];
                }
                first = lhtrht[4];
            }
            first = ans;
            pre = null;
        }
        return ans;
    }

    private ListNode[] lhtrht(ListNode first, int len) {
        ListNode lh = first;
        ListNode lt = first;
        ListNode rh = null;
        ListNode rt = null;
        ListNode next = null;
        int count = 0;
        while (first != null) {
            count++;
            if (count <= len) {
                lt = first;
            }
            if (count == len + 1) {
                rh = first;
            }
            if (count > len) {
                rt = first;
            }
            if (count == (len << 1)) {
                break;
            }
            first = first.next;
        }
        lt.next = null;
        if (rt != null) {
            next = rt.next;
            rt.next = null;
        }
        return new ListNode[]{lh, lt, rh, rt, next};
    }

    private ListNode[] merge(ListNode lh, ListNode lt, ListNode rh, ListNode rt) {
        if (rh == null) {
            return new ListNode[]{lh, lt};
        }
        ListNode head = null;
        ListNode tail = null;
        ListNode pre = null;
        ListNode curr = null;
        while (lh != null && rh != null) {
            if (lh.val < rh.val) {
                curr = lh;
                lh = lh.next;
            } else {
                curr = rh;
                rh = rh.next;
            }
            if (head == null) {
                head = curr;
                pre = curr;
            } else {
                pre.next = curr;
                pre = curr;
            }
        }
        if (lh != lt.next) {
            while (lh != null) {
                if (head == null) {
                    head = lh;
                } else {
                    pre.next = lh;
                }
                pre = lh;
                tail = lh;
                lh = lh.next;
            }
        } else {
            while (rh != null) {
                if (head == null) {
                    head = rh;
                } else {
                    pre.next = rh;
                }
                pre = rh;
                tail = rh;
                rh = rh.next;
            }
        }

        return new ListNode[]{head, tail};
    }
}
