package cn.baymax.mac03;
//https://leetcode.cn/problems/validate-binary-search-tree/
//98
public class Code05_IsBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Info info = process(root);
        return info.isBST;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return null;
        }
        //二叉搜索树
        //1、左树值<当前节点值
        //2、右树值>当前节点值
        //3、左树的最大值<当前值  && 右树的最小>当前值
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int max = root.val;
        int min = root.val;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.minVal);
            max = Math.max(max, leftInfo.maxVal);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.minVal);
            max = Math.max(max, rightInfo.maxVal);
        }
        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        if (leftInfo != null && leftInfo.maxVal >= root.val) {
            isBST = false;
        }
        if (rightInfo != null && rightInfo.minVal <= root.val) {
            isBST = false;
        }
        return new Info(isBST, min, max);
    }

    public class Info {
        boolean isBST;
        int minVal;
        int maxVal;

        public Info(boolean isBST, int minVal, int maxVal) {
            this.isBST = isBST;
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }

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

}
