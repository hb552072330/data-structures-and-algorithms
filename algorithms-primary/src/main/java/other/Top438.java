package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhanghongbing
 * @Date 2025-11-20 21:43
 **/
public class Top438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return new ArrayList<>();
        }
        int sLen = s.length(), pLen = p.length();
        int[] pArr = new int[26], sArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ++pArr[p.charAt(i) - 'a'];
            ++sArr[s.charAt(i) - 'a'];
        }
        List<Integer> ans = new ArrayList<>();
        if (Arrays.equals(pArr, sArr)) {
            ans.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            ++sArr[s.charAt(i)-'a'];
            --sArr[s.charAt(i - pLen) -'a'];
            if (Arrays.equals(pArr, sArr)) {
                ans.add(i - pLen + 1);
            }
        }
        return ans;
    }
}
