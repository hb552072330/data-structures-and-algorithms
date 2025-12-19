package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-18 22:50
 **/
public class Top104 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left) + 1;
        int r = maxDepth(root.right) + 1;
        return Math.max(l, r);
    }

}
