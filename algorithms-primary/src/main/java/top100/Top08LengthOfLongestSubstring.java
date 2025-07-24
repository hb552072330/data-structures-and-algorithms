package top100;

import java.util.HashSet;
import java.util.Set;

public class Top08LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        int left = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (left + 1 < s.length() && !set.contains(s.charAt(left + 1))) {
                set.add(s.charAt(left + 1));
                left++;
            }
            ans = Math.max(ans, left - i + 1);
        }
        return ans;
    }

}
