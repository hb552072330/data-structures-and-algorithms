package top100;

import java.util.ArrayList;
import java.util.List;

public class Top57LetterCombinations {


    public static char[][] phone = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };


    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        char[] str = digits.toCharArray();
        char[] path = new char[digits.length()];
        process(str, 0, path, ans);
        return ans;
    }

    public void process(char[] str, int idx, char[] path, List<String> ans) {
        if (idx == str.length) {
            ans.add(String.valueOf(path));
        } else {
            char[] cands = phone[str[idx] - '2'];
            for (char c : cands) {
                path[idx] = c;
                process(str, idx + 1, path, ans);
            }
        }
    }
}
