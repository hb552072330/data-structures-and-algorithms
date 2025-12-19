package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-22 11:41
 **/
public class Top76 {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int sLen = s.length(), tLen = t.length();
        int l = 0, r = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int ansL = -1, minLen = Integer.MAX_VALUE;
        int[] map = new int[256];
        for (char tChar : tChars) {
            map[tChar]++;
        }
        for (int i = 0; i < sLen; i++) {
            map[sChars[i]]--;
            if (map[sChars[i]] >= 0) {
                tLen--;
            }
            if (tLen == 0) {
                while (map[sChars[l]] < 0) {
                    map[sChars[l++]]++;
                }
                r = i;
                if (minLen > r - l + 1) {
                    ansL = l;
                    minLen = r - l + 1;
                }
                map[sChars[l++]]++;
                tLen++;
            }

        }
        return ansL < 0 ? "" : new String(sChars, ansL, minLen);
    }
}
