package top100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Top12MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //[1,3,-1,-3,5,3,6,7]
            //[3,3,5,5,6,7]
            System.out.println(i + "" + deque) ;
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            // i    idx  v   left
            //i=0
            //i=1   1    3
            //i=2   1    3   0
            //i=3   1    3   1
            //i=4       3
            deque.addLast(i);
            int left = i - k + 1;
            if (deque.getFirst() < left) {
                deque.removeFirst();
            }
            if (left >= 0) {
                ans[left] = nums[deque.getFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
    }
}
