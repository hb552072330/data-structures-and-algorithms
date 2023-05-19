package cn.baymax.mac04;

//https://leetcode.cn/problems/longest-increasing-subsequence/
//300
public class Code03_LIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int right = 0;
        int ans = 1;
        int[] lessIncrSeq = new int[nums.length];
        lessIncrSeq[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int l = 0;
            int r = right;
            while (l <= r) {
                int m = l + ((r - l) >> 1);
                if (nums[i] > lessIncrSeq[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            lessIncrSeq[l] = nums[i];
            right = Math.max(l, right);
            ans = Math.max(ans, l + 1);

        }
        return ans;
    }


    public int lengthOfLIS3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //[5,1,4,6,4,2,4]
        //1,4,6
        int ans = 1;
        int[] lessIncrSeq = new int[nums.length];
        lessIncrSeq[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = ans - 1; j >= 0; j--) {
                int curJ = lessIncrSeq[j];
                if (cur <= curJ) {
                    if (j - 1 >= 0 && cur <= lessIncrSeq[j - 1]) {
                        continue;
                    }
                    lessIncrSeq[j] = cur;
                    break;
                } else {
                    if (j + 1 == ans) {
                        lessIncrSeq[ans] = cur;
                        ans++;
                    } else {
                        lessIncrSeq[j] = cur;
                    }
                    break;
                }
            }
        }
        return ans;
    }

    //动态规划 O(n^2)
    public int lengthOfLIS2DP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            int curMax = 0;
            for (int i1 = 0; i1 < i; i1++) {
                if (nums[i1] < nums[i]) {
                    curMax = Math.max(curMax, dp[i1]);
                }
            }
            dp[i] = curMax + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
