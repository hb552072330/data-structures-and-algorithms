package top100;

public class Top95MinDistance {
    public static int minDistance(String word1, String word2) {
        int cost = 1;
        int M = word1.length() + 1;
        int N = word2.length() + 1;
        int[][] dp = new int[M][N];
        for (int i = 1; i < M; i++) {
            dp[i][0] = i * cost;
        }
        for (int j = 0; j < N; j++) {
            dp[0][j] = j * cost;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                int p1 = dp[i][j - 1] + 1;
                int p2 = dp[i - 1][j] + 1;
                int p3 = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                dp[i][j] = Math.min(Math.min(p1, p2), p3);
            }
        }
        return dp[M - 1][N - 1];
    }


    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
}
