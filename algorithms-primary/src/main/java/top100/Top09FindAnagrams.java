package top100;

import java.util.*;

public class Top09FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return ans;
        }
        int pLen = p.length(), sLen = s.length();
        int[] pArr = new int[26];
        int[] sArr = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++pArr[p.charAt(i) - 'a'];
            ++sArr[s.charAt(i) - 'a'];
        }
        if (Arrays.equals(pArr, sArr)) {
            ans.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            ++sArr[s.charAt(i + pLen) - 'a'];
            --sArr[s.charAt(i) - 'a'];
            if (Arrays.equals(pArr, sArr)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

            String s = "cbaebabacd";
            String p =         "abc";
            System.out.println(findAnagrams(s, p));

    }
}
