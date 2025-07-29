package top100;

public class Top41DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        depth2(root);
        return ans2;
    }

    private int depth2(TreeNode root) {
        if (root == null)
            return -1;
        int L = depth2(root.left) + 1;
        int R = depth2(root.right) + 1;
        ans2 = Math.max(ans2, L + R);
        return Math.max(L, R);
    }


    int ans2 = 0;

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }

    int ans = 1;
}
