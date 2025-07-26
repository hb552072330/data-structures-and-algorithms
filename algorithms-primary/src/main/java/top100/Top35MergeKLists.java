package top100;

import java.util.List;
import java.util.PriorityQueue;

public class Top35MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            queue.add(list);
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            ListNode next = poll.next;
            if (next != null) {
                queue.add(next);
            }
            curr.next = poll;
            curr = poll;
        }
        return dummy.next;
    }
}
