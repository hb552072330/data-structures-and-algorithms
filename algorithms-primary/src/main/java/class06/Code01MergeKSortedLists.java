package class06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhanghongbing
 * @data 2022/9/8
 * 23
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 */

public class Code01MergeKSortedLists {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode poll = heap.poll();
            pre.next = poll;
            pre = poll;
            if (poll.next != null) {
                heap.add(poll.next);
            }
        }
        return head;
    }
}
