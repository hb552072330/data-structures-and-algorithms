package top100;

import java.util.List;

public class Top87WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return false;
        }
        Node root = new Node();
        for (String str : wordDict) {
            Node cur = root;
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                if (cur.nexts[idx] == null) {
                    cur.nexts[idx] = new Node();
                }
                cur = cur.nexts[idx];
            }
            cur.end = true;
        }
        boolean dp[] = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            Node cur = root;
            for (int end = i; end < s.length(); end++) {
                cur = cur.nexts[s.charAt(end) - 'a'];
                if (cur == null) {
                    break;
                }
                if (cur.end) {
                    dp[i] |= dp[end + 1];
                }
                if (dp[i]) {
                    break;
                }
            }

        }
        return dp[0];
    }


    public static class Node {
        private Node[] nexts;
        private boolean end;

        public Node() {
            nexts = new Node[26];
        }
    }

    private static void dp(String s, int l, int r, int[] dp, List<String> wordDict) {
        if (l > r) {
            return;
        }
        String tag = s.substring(l, r);
        if (wordDict.contains(tag)) {
            for (int i = 0; i < tag.length(); i++) {
                dp[tag.charAt(i) - 'a']--;
            }
        }
        dp(s, l, r - 1, dp, wordDict);
    }

    public static void main(String[] args) {

    }
}
