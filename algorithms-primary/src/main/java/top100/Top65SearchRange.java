package top100;

public class Top65SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int first = -1, last = -1;
        int L = 0, R = nums.length - 1;
        while (L <= R) {
            int M = ((R - L) >> 1) + L;
            if (nums[M] == target) {
                first = M;
                R = M - 1;
            } else if (nums[M] > target) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        L = 0;
        R = nums.length - 1;
        while (L <= R) {
            int M = ((R - L) >> 1) + L;
            if (nums[M] == target) {
                last = M;
                L = M + 1;
            } else if (nums[M] > target) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }

        ans[0] = first;
        ans[1] = last;
        return ans;
    }
}
