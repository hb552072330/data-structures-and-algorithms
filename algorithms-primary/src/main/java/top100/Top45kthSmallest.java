package top100;

public class Top45kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || root.val < k) {
            return 0;
        }

        return kthSmallest(root.left, k);
    }

}
