package top100;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Top61Partition {
    public static List<List<String>> partition(String s) {
        if (s == null) {
            return new ArrayList<>();
        }
        int len = s.length();
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        boolean[][] check = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(check[i], true);
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                check[i][j] = (s.charAt(i) == s.charAt(j)) && check[i + 1][j - 1];
            }
        }
        dfs(s, 0, path, ans, check);

        return ans;
    }

    private static void dfs(String s, int i, List<String> path, List<List<String>> ans, boolean[][] check) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (check[i][j]) {
                path.add(s.substring(i, j + 1));
                dfs(s, j + 1, path, ans, check);
                path.remove(path.size() - 1);
            }
        }
    }

    public static List<List<String>> partition2(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null) {
            return ans;
        }
        if (s.length() < 2) {
            List<String> cur = new ArrayList<>();
            cur.add(s);
            ans.add(cur);
            return ans;
        }
        char[] chars = s.toCharArray();
        boolean[][] check = creatCheckMap(chars);
        int len = s.length();
        int[] dp = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            //是回文串
            if (check[i][len - 1]) {
                dp[i] = 1;
            } else {
                int next = Integer.MAX_VALUE;
                for (int j = i; j < len; j++) {
                    if (check[i][j]) {
                        next = Math.min(next, dp[j + 1]);
                    }
                }
                dp[i] = 1 + next;
            }
        }
        process(s, 0, 1, check, dp, new ArrayList<>(), ans);
        return ans;
    }

    private static void process(String s, int i, int j, boolean[][] check, int[] dp, ArrayList<String> path, List<List<String>> ans) {
        if (s.length() == j) {
            if (check[i][j - 1] && dp[i] == dp[j] + 1) {
                path.add(s.substring(i, j));
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
        } else {
            process(s, i, j + 1, check, dp, path, ans);
            if (check[i][j - 1] && dp[i] == dp[j] + 1) {
                path.add(s.substring(i, j));
                process(s, j, j + 1, check, dp, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    public static boolean[][] creatCheckMap(char[] chars) {
        int len = chars.length;
        boolean[][] res = new boolean[len][len];
        for (int i = 0; i < len - 1; i++) {
            res[i][i] = true;
            res[i][i + 1] = chars[i] == chars[i + 1];
        }
        res[len - 1][len - 1] = true;
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                res[i][j] = chars[i] == chars[j] && res[i + 1][j - 1];
            }
        }
        return res;
    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(14);
            add(13);
            add(12);

        }};
//        System.out.println(list);
//        list.remove(list.size() - 1);
//        System.out.println(list);

        System.out.println("000000");
//        System.out.println(partition("abacd"));
        System.out.println(partition("abcdc"));
//        System.out.println(partition("ab"));
    }

}
