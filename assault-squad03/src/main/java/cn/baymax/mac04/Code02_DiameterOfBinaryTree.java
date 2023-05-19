package cn.baymax.mac04;

//https://leetcode.cn/problems/diameter-of-binary-tree/
//543
public class Code02_DiameterOfBinaryTree {

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
        int distance;

        public Info(int height, int distance) {
            this.height = height;
            this.distance = distance;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //和根节点有关 左树的最大高度 + 右树的最大高度 + 当前节点
        //和根节点无关  右树或最大长度
        Info info = process(root);
        return info.distance;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int distance = Math.max(leftInfo.distance, rightInfo.distance);
        distance = Math.max(distance, leftInfo.height + rightInfo.height);
        return new Info(Math.max(rightInfo.height, leftInfo.height) + 1, distance);
    }
}
