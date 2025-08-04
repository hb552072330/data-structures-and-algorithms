package top100;

import java.util.ArrayList;
import java.util.List;

public class Top58CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int index, int target, ArrayList<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    continue;
                }
                list.add(candidates[i]);
                backtrack(candidates, i, target - candidates[i], list, ans);
                list.remove(list.size() - 1);
            }
        }
    }


}
