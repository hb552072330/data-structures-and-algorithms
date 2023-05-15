package cn.baymax.mac03;

public class Code06_IsBalanced {
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

    public class Info {
        int height;
        boolean isBalanced;

        public Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Info info = process2(root);
        return info.isBalanced;
    }


    private Info process2(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }
        Info leftInfo = process2(root.left);
        Info righInfo = process2(root.right);
        boolean isBalanced = leftInfo.isBalanced && righInfo.isBalanced && Math.abs(leftInfo.height - righInfo.height) <= 1;
        int height = Math.max(leftInfo.height, righInfo.height)+1;
        return new Info(height, isBalanced);

    }

    private Info process(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = process(root.left);
        Info righInfo = process(root.right);
        boolean isBalanced = true;
        int height = 0;
        int leftHight = leftInfo == null ? 0 : leftInfo.height;
        int rightHight = righInfo == null ? 0 : righInfo.height;
        height = Math.max(leftHight, rightHight);
        isBalanced = Math.abs(leftHight - rightHight) <= 1;
        if (leftInfo != null && !leftInfo.isBalanced) {
            isBalanced = false;
        }
        if (righInfo != null && !righInfo.isBalanced) {
            isBalanced = false;
        }
        return new Info(height + 1, isBalanced);
    }
}
