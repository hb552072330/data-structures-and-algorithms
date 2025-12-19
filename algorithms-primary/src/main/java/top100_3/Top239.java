package top100_3;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author zhanghongbing
 * @Date 2025-10-17 21:59
 **/
public class Top239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            int idx = i - k + 1;
            if (queue.getFirst() < idx) {
                queue.removeFirst();
            }
            if (idx >= 0) {
                ans[idx] = nums[queue.getFirst()];
            }
        }
        return ans;
    }
}
