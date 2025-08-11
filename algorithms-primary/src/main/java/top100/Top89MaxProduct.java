package top100;

import java.util.Arrays;

public class Top89MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curMax = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));
            max = curMax;
            ans = Math.max(max, ans);
        }
        return ans;
    }

    public int maxProduct2(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        Arrays.fill(dpMax, Integer.MIN_VALUE);
        Arrays.fill(dpMin, Integer.MIN_VALUE);
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int p1 = nums[i] * dpMax[i - 1];
            int p2 = nums[i] * dpMin[i - 1];
            dpMax[i] = Math.max(Math.max(p1, p2), nums[i]);
            dpMin[i] = Math.min(Math.min(p1, p2), nums[i]);
            ans = Math.max(ans, dpMax[i]);
        }
        return ans;
    }
}
