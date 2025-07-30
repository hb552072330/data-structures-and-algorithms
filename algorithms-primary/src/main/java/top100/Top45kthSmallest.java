package top100;

public class Top45kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        bst(root);
        return res;
    }

    int res, k;

    public void bst(TreeNode node) {
        if (node == null) {
            return;
        }
        bst(node.left);
        if (k == 0) {
            return;
        }
        if (--k == 0)
            res = node.val;
        bst(node.right);
    }

}
