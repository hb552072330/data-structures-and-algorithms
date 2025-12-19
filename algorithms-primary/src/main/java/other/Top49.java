package other;

import java.util.*;

/**
 * @Author zhanghongbing
 * @Date 2025-11-20 18:41
 **/
public class Top49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) return null;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            map.computeIfAbsent(new String(strArr), e -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
