package class07;

import java.util.ArrayList;
import java.util.List;

public class Code04PathSumII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        process(root, 0, targetSum, path, ans);
        return ans;
    }

    private void process(TreeNode root, int preSum, int targetSum, ArrayList<Integer> path, List<List<Integer>> ans) {
        if (root.left == null && root.right == null) {
            if (targetSum == preSum + root.val) {
                path.add(root.val);
                List<Integer> meetList = copy(path);
                path.remove(path.size() - 1);
                ans.add(meetList);
            }
            return;
        }
        path.add(root.val);
        preSum += root.val;
        if (root.left != null) {
            process(root.left, preSum, targetSum, path, ans);
        }

        if (root.right != null) {
            process(root.right, preSum, targetSum, path, ans);
        }
        path.remove(path.size() - 1);
    }

    private List<Integer> copy(ArrayList<Integer> path) {
        List<Integer> res = new ArrayList<>();
        for (Integer integer : path) {
            res.add(integer);
        }
        return res;
    }


}
