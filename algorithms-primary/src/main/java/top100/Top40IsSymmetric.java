package top100;

public class Top40IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null ^ right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        return left.val == right.val && isSame(left.right, right.left) && isSame(left.left, right.right);
    }
}
