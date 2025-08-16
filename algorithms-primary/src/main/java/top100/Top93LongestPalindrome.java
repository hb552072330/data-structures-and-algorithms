package top100;

import java.util.Arrays;

public class Top93LongestPalindrome {
    public static String longestPalindrome(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        char[] str = new char[len * 2 + 1];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            str[j++] = '#';
            str[j++] = chars[i];
        }
        str[j] = '#';
        int[] dp = new int[str.length];
        int center = 0;
        int right = -1;
        int max = 1;
        int left = 0;
        for (int i = 0; i < str.length; i++) {
            dp[i] = right > i ? Math.min(dp[2 * center - i], right - i) : 1;
            while (dp[i] + i < str.length && i - dp[i] > -1) {
                if (str[dp[i] + i] == str[i - dp[i]]) {
                    dp[i]++;
                } else {
                    break;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                left = i - dp[i] + 1;
            }
            if (dp[i] + i > right) {
                right = dp[i] + i;
                center = i;
            }
        }
        String ans = new String(str, left, 2 * max - 1);
        return ans.replaceAll("#", "");

    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], true);
        }
        int L = 0, R = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    if ((j - i + 1) > (R - L)) {
                        L = i;
                        R = j + 1;
                    }
                }
            }
        }
        return s.substring(L, R);
    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println(s.substring(0, 3));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("saa"));
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("aaersx"));
    }

}
