package top100;

import java.util.*;

public class Top02GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return null;
        }
        List<List<String>> ans = new ArrayList<>();
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        for (int length = strs.length - 1; length >= 0; length--) {
            String str = strs[length];
            String sortStr = sortStr(str);
            map.computeIfAbsent(sortStr, k -> new ArrayList<String>()).add(str);
        }
        Collection<List<String>> values = map.values();
        System.out.println(values);
        if (!values.isEmpty()) {
            ans = new ArrayList<>(map.values());
            for (int i = 0; i < ans.size(); i++) {
                Collections.sort(ans.get(i));
            }
        }
        return ans;
    }

    private static String sortStr(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        System.out.println(Arrays.toString(charArray));
        return new String(charArray);
    }

    //输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    //
    //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    //[[bat], [nat, tan], [ate, tea, eat]]
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
