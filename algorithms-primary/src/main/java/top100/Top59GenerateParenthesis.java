package top100;

import java.util.ArrayList;
import java.util.List;

public class Top59GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        processGenerate(new char[n << 1], 0, 0, n, ans);
        return ans;
    }

    private void processGenerate(char[] path, int index, int leftMinusRight, int lefRest, List<String> ans) {
        if (index == path.length) {
            ans.add(String.valueOf(path));
        } else {
            if (lefRest > 0) {
                path[index] = '(';
                processGenerate(path, index + 1, leftMinusRight + 1, lefRest - 1, ans);
            }
            if (leftMinusRight > 0) {
                path[index] = ')';
                processGenerate(path, index + 1, leftMinusRight - 1, lefRest, ans);
            }
        }
    }
}
