package top100;

public class Top94LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M][N];
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        dp[0][0] = s1[0] == s2[0] ? 1 : 0;
        for (int i = 1; i < N; i++) {
            dp[0][i] = s1[0] == s2[i] ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < M; i++) {
            dp[i][0] = s2[0] == s1[i] ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                int p1 = dp[i][j - 1];
                int p2 = dp[i - 1][j];
                int p3 = s1[i] == s2[j] ? (1 + dp[i - 1][j - 1]) : 0;
                dp[i][j] = Math.max(Math.max(p1, p2), p3);
            }
        }
        return dp[M - 1][N - 1];
    }

    public static void main(String[] args) {
        //测试用例:"abcde"
        //			"ace"
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

}
