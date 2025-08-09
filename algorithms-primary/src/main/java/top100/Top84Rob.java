package top100;

public class Top84Rob {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;

        if (len < 2) {
            return nums[0];
        }

        int pre1 = nums[0];
        int pre2 = Math.max(nums[0], nums[1]);
        int ans = pre2;
        for (int i = 2; i < len; i++) {
            int max = Math.max(nums[i], pre2);
            ans = Math.max(nums[i] + pre1, max);
            pre1 = pre2;
            pre2 = ans;
        }
        return ans;
    }

    public int rob2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;

        if (len < 2) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int max = Math.max(nums[i], dp[i - 1]);
            dp[i] = Math.max(nums[i] + dp[i - 2], max);
        }
        return dp[len - 1];
    }


}
