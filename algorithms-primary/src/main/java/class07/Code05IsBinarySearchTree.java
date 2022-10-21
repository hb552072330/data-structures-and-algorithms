package class07;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * 98
 */
public class Code05IsBinarySearchTree {
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

    public boolean isValidBST(TreeNode root) {
        Info info = process(root);
        return info.isBST;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int max = root.val;
        int min = root.val;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }

        boolean leftIsBST = leftInfo == null ? true : leftInfo.isBST;
        boolean rigthIsBST = rightInfo == null ? true : rightInfo.isBST;
        boolean leftMaxLessCur = leftInfo == null ? true : leftInfo.max < root.val;
        boolean rigthMinMroeCur = rightInfo == null ? true : rightInfo.min > root.val;
        if (leftIsBST && rigthIsBST && leftMaxLessCur && rigthMinMroeCur) {
            return new Info(true, max, min);
        }
        return new Info(false, max, min);
    }

    public class Info {
        boolean isBST;
        int max;
        int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

}
