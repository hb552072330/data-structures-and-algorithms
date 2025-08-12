package top100;

public class Top91LongestValidParentheses {
    public int longestValidParentheses(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        int len = s.length();
        int dp[] = new int[len];
        int pre = 0;
        for (int i = 1; i < len; i++) {
            pre = i - dp[i - 1] - 1;
            char c = s.charAt(i);
            if (c == ')' && pre >= 0) {
                if (s.charAt(pre) == '(') {
                    dp[i] = i - pre + 1 + (pre >0 ? dp[pre - 1] : 0);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
