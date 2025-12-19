package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanghongbing
 * @data 2022/9/23
 * 76
 * https://leetcode.cn/problems/minimum-window-substring/
 */
public class LeetCode76_II {

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return new String();
        }
        Map<Character, Integer> constainer = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            constainer.put(t.charAt(i), constainer.getOrDefault(t.charAt(i), 0) + 1);
        }

        int len = Integer.MAX_VALUE;
        int start = -1;
        int rStart = 0;
        int lStart = 0;
        for (; rStart < sLen; rStart++) {
            char cur = s.charAt(rStart);
            if (constainer.containsKey(cur)) {
                if (constainer.get(cur) > 0) {
                    tLen--;
                }
                constainer.put(cur, constainer.get(cur) - 1);
            }
            if (tLen == 0) {
                while (lStart < rStart) {
                    if (constainer.containsKey(s.charAt(lStart))) {
                        if (constainer.get(s.charAt(lStart)) < 0) {
                            constainer.put(s.charAt(lStart), constainer.get(s.charAt(lStart)) + 1);
                            lStart++;
                        } else {
                            break;
                        }
                    } else {
                        lStart++;
                    }
                }
                if (rStart - lStart + 1 < len) {
                    start = lStart;
                    len = rStart - lStart + 1;
                }
            }
        }

        if (-1 == start) {
            return new String();
        }
        return s.substring(start, start + len);

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        LeetCode76_II leetCode76 = new LeetCode76_II();
        System.out.println(leetCode76.minWindow(s, t));
    }
    //"ADOBECODEBANC"
    //"ABC"
}
