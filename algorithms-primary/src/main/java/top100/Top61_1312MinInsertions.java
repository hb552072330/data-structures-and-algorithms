package top100;

public class Top61_1312MinInsertions {

    public int minInsertions(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] chars = s.toCharArray();
        for (int i = 1; i < len; i++) {
            if (chars[i] != chars[i - 1]) {
                dp[i - 1][i] = 1;
            }
        }

        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                if (chars[i] == chars[j]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
