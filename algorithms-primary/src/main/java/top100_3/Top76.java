package top100_3;

/**
 * @Author zhanghongbing
 * @Date 2025-10-17 22:20
 **/
public class Top76 {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int L = 0, R = 0;
        int[] map = new int[256];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sLen = s.length();
        int tLen = t.length();
        int ansL = -1, ansR = -1;
        for (char c : tChars) {
            map[c]++;
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sLen; i++) {
            map[sChars[i]]--;
            if (map[sChars[i]] >= 0) {
                tLen--;
            }
            if (tLen == 0) {
                while (map[sChars[L]] < 0) {
                    map[sChars[L++]]++;
                }
                R = i;
                if (minLen > R - L + 1) {
                    ansR = R;
                    ansL = L;
                    minLen = R - L + 1;
                }
                tLen++;
                map[sChars[L++]]++;
            }
        }
        return ansR > 0 ? "" : s.substring(ansL, ansR + 1);
    }

}
