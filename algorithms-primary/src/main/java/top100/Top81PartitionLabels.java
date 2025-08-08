package top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top81PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        if (s == null) {
            return ans;
        }
        char[] chars = s.toCharArray();
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[chars[i] - 'a'] = i;
        }
        int left = 0;
        int right = dict[chars[0] - 'a'];
        for (int i = 0; i < chars.length; i++) {
            if (i > right) {
                ans.add(right - left + 1);
                left = i;
            }
            right = Math.max(right, dict[chars[i] - 'a']);
        }
        ans.add(right - left + 1);
        return ans;
    }

    public static List<Integer> partitionLabels2(String s) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            ans.add(0);
            return ans;
        }
        Map<Character, Integer> dict = new HashMap<>();
        char[] chars = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            dict.put(chars[i], i);
        }
        int L = 0, R = 0;
        int curr = 0;
        while (L < len) {
            R = Math.max(R, dict.get(chars[L++]));
            if (L > R) {
                ans.add(R - curr + 1);
                curr = L;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
