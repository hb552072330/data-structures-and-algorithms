package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Top62SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n < 1) {
            return ans;
        }
        process(0, new int[n], n, ans);
        return ans;
    }

    public static void process(int i, int[] record, int n, List<List<String>> ans) {
        if (i == n) {
            List<String> cur = new ArrayList<>();
            for (int k = 0; k < record.length; k++) {
                char[] ints = new char[n];
                Arrays.fill(ints, '.');
                ints[record[k]] = 'Q';
                cur.add(new String(ints));
            }
            ans.add(cur);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                process(i + 1, record, n, ans);
            }
        }
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }


}
