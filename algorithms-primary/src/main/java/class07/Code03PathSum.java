package class07;

/**
 * @author zhanghongbing
 * @data 2022/9/22
 * 112
 * https://leetcode.cn/problems/path-sum
 */
public class Code03PathSum {
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

    private boolean isSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        process(root, 0, targetSum);
        return isSum;
    }

    private void process(TreeNode root, int preSum, int targetSum) {
        if (root.left == null && root.right == null) {
            if (targetSum == preSum + root.val) {
                isSum = true;
            }
            return;
        }
        preSum += root.val;
        if (root.left != null) {
            process(root.left, preSum, targetSum);
        }
        if (root.right != null) {
            process(root.right, preSum, targetSum);
        }

    }

}
