package other;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhanghongbing
 * @data 2022/9/23
 * 76
 * https://leetcode.cn/problems/minimum-window-substring/
 */
public class LeetCode76 {

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return new String();
        }
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            cnt.put(t.charAt(i), cnt.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int ansStart = -1;
        int ansLen = Integer.MAX_VALUE;
        for (int r = 0; r < sLen; r++) {
            if (cnt.containsKey(s.charAt(r))) {
                if (cnt.get(s.charAt(r)) > 0) {
                    tLen--;
                }
                cnt.put(s.charAt(r), cnt.get(s.charAt(r)) - 1);
            }
            if (tLen == 0) {
                while (true) {
                    if (!cnt.containsKey(s.charAt(l))) {
                        l++;
                    } else {
                        if (cnt.get(s.charAt(l)) < 0) {
                            cnt.put(s.charAt(l), cnt.get(s.charAt(l)) + 1);
                            l++;
                        } else {
                            break;
                        }
                    }
                }
                if (r - l + 1 < ansLen) {
                    ansStart = l;
                    ansLen = r - l + 1;
                }
            }
        }
        if (ansStart == -1) {
            return new String();
        }
        return s.substring(ansStart, ansStart + ansLen);
    }

    public static void main(String[] args) {
        String s = "abc2ae32fg";
        String t = "ce";
        LeetCode76 leetCode76 = new LeetCode76();
        System.out.println(leetCode76.minWindow(s, t));
    }
}
