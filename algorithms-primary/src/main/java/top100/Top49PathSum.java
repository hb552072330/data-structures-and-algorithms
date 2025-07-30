package top100;

import java.util.HashMap;
import java.util.Map;

public class Top49PathSum {

    public int pathSum2(TreeNode root, long targetSum) {

        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, long targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        int val = root.val;
        curr += val;
        //10
        //15
        //18-8= 10
        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return ret;
    }


    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, long tSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (root.val == tSum) {
            ret++;
        }
        ret += rootSum(root.left, tSum - root.val);
        ret += rootSum(root.right, tSum - root.val);
        return ret;
    }
}
