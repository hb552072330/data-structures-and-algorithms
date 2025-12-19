package top100_3;

import java.util.*;

/**
 * @Author zhanghongbing
 * @Date 2025-10-13 17:00
 **/
public class Top438 {
    public static List<Integer> findAnagrams2(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ++sArr[s.charAt(i) - 'a'];
            pArr[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArr, pArr)) {
            ans.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            sArr[s.charAt(i)- 'a']--;
            sArr[s.charAt(i + p.length())- 'a']++;
            if (Arrays.equals(sArr, pArr)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return findAnagrams(p, s);
        }
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (int i = 0; i < pLen; i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int l = pLen - 1;
        while (l < sLen) {
            if (l - pLen + 1 > 0) {
                sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l), 0) + 1);
                char c = s.charAt(l - pLen);
                if (sMap.get(c) == 1) {
                    sMap.remove(c);
                } else {
                    sMap.put(c, sMap.get(c) - 1);
                }
            }
            if (isAnagrams(sMap, pMap)) {
                ans.add(l - pLen + 1);
            }
            l++;
        }
        return ans;
    }

    private static boolean isAnagrams(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
        for (Map.Entry<Character, Integer> entry : pMap.entrySet()) {
            if (sMap.containsKey(entry.getKey()) && sMap.get(entry.getKey()).equals(entry.getValue())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

}
