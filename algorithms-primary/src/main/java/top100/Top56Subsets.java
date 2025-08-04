package top100;

import java.util.ArrayList;
import java.util.List;

public class Top56Subsets {
    List<Integer> cur = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int i, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        dfs(i + 1, nums);
        cur.remove(cur.size() - 1);
        dfs(i + 1, nums);
    }

    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            backtrack(0, i, new ArrayList<Integer>(), nums, ans);
        }
        return ans;
    }

    private void backtrack(int start, int k, ArrayList<Integer> cur, int[] nums, List<List<Integer>> ans) {
        if (k == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                cur.add(nums[i]);
                backtrack(i + 1, k - 1, cur, nums, ans);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        ans.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> an : ans) {
                List<Integer> newSub = new ArrayList<>(an);
                an.add(num);
                newSubsets.add(newSub);
            }
            ans.addAll(newSubsets);
        }
        return ans;
    }
}
