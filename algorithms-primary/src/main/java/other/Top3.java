package other;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zhanghongbing
 * @Date 2025-11-20 21:36
 **/
public class Top3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int ans = 1;
        int l = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (l + 1 < s.length() && !set.contains(s.charAt(l + 1))) {
                set.add(s.charAt(l + 1));
                l++;
            }
            ans = Math.max(ans, l - i + 1);
        }
        return ans;
    }
}
