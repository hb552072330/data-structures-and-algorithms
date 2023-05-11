package cn.baymax.mac03;

import java.util.PriorityQueue;
//https://leetcode.cn/problems/merge-k-sorted-lists/
//23题
public class Code01_MergeKSortedLists {

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
    //todo 注意边界条件 []  [[]]
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.offer(list);
            }
        }
        if (priorityQueue.isEmpty()) {
            return null;
        }
        ListNode ans = priorityQueue.poll();
        ListNode next = ans.next;
        if (next != null) {
            priorityQueue.offer(next);
        }
        ListNode cur = ans;
        while (!priorityQueue.isEmpty()) {
            next = priorityQueue.poll();
            cur.next = next;
            cur = next;
            if (next.next != null) {
                priorityQueue.offer(next.next);
            }
        }
        return ans;
    }
}
