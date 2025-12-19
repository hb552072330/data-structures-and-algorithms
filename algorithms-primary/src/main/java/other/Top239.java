package other;

import java.util.LinkedList;

/**
 * @Author zhanghongbing
 * @Date 2025-11-22 11:25
 **/
public class Top239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return nums;
        }
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!list.isEmpty() && nums[list.getLast()] <= nums[i]) {
                list.removeLast();
            }
            list.addLast(i);
            int idx = i - k + 1;
            if (list.getFirst() < idx) {
                list.removeFirst();
            }
            if (idx >= 0) {
                ans[idx] = nums[list.getFirst()];
            }
        }
        return ans;
    }
}
