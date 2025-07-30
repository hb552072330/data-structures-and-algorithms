package top100;

public class Top44IsValidBST {
    public boolean isValidBST(TreeNode root) {

        return isBSt(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean isBSt(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isBSt(root.left, minValue, root.val) && isBSt(root.right, root.val, maxValue);
    }
}
