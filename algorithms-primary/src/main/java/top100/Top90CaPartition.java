package top100;

import java.util.Arrays;

public class Top90CaPartition {
    public static boolean canPartition(int[] nums) {
        if (null == nums) {
            return false;
        }
        int len = nums.length;
        if (len == 1) {
            return false;

        }
        int maxValue = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            maxValue = Math.max(num, maxValue);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int tag = sum >> 1;
        if (maxValue > tag) {
            return false;
        }
        boolean[][] dp = new boolean[len][tag + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            for (int j = 1; j <= tag; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        print(dp);

        return dp[len - 1][tag];
    }

    private static void print(boolean[][] dp) {
        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
    }

    public static void main(String[] args) {
        canPartition(new int[]{6,3,1,2});
//        canPartition(new int[]{1,2,3,6});
    }

}