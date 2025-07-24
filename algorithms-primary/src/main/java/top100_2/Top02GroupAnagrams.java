package top100_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top02GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null){
            return null;
        }
        Map<String, List<String>> ansMap = new HashMap<>();
        for (String str : strs) {
            int[] tempArr = new int[26];
            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                tempArr[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tempArr.length; i++) {
                if (tempArr[i] != 0) {
                    sb.append((char)('a' + i)).append(tempArr[i]);
                }
            }
            List<String> list = ansMap.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            ansMap.put(sb.toString(), list);
        }
        return new ArrayList<>(ansMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

}
