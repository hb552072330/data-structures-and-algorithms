package top100;

import java.util.ArrayList;
import java.util.List;

public class Top83Generate {
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            int j = 0;
            while (j <= i) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> list = ans.get(i - 1);
                    row.add(list.get(j) + list.get(j - 1));
                }
                j++;
            }
            ans.add(row);
        }
        return ans;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows < 1) {
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(list);
        if (numRows < 2) {
            return ans;
        }
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        ans.add(list2);
        for (int i = 3; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            int j = 1;
            cur.add(1);
            List<Integer> pre = ans.get(ans.size() - 1);
            while (j < i - 1) {
                cur.add(pre.get(j) + pre.get(j - 1));
                j++;
            }
            cur.add(1);
            ans.add(cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(7);
        for (List<Integer> list : generate) {
            System.out.println(list);
        }
    }

}
