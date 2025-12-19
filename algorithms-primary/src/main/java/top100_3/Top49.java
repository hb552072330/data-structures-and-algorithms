package top100_3;

import java.util.*;

/**
 * @Author zhanghongbing
 * @Date 2025-10-10 22:51
 **/
public class Top49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            map.computeIfAbsent(new String(charArray), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
