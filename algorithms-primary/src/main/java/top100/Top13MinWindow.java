package top100;

import java.util.HashMap;
import java.util.Map;

public class Top13MinWindow {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        char[] str = s.toCharArray();
        char[] tar = t.toCharArray();
        int len = str.length;
        int all = tar.length;
        int[] map = new int[256];
        for (char c : tar) {
            map[c]++;
        }
        int L = 0, R = 0;
        int ansL = -1, ansR = -1;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            map[str[i]]--;
            if (map[str[i]] >= 0) {
                all--;
            }
            if (all == 0) {
                while (map[str[L]] < 0) {
                    map[str[L++]]++;
                }
                R = i;
                if (minLen > R - L + 1) {
                    ansR = R;
                    ansL = L;
                    minLen = R - L + 1;
                }
                all++;
                map[str[L++]]++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR + 1);
    }


    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
