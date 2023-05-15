package cn.baymax.mac04;

//https://leetcode.cn/problems/diameter-of-binary-tree/
//543
public class Code01_CompleteTreeNodeNumber {
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


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return bs(root, 1, mostLeftLevel(root, 1));
//        return process(root, 0);
    }
    // node : 当前来到的树的头部，当前这棵树一定是完全二叉树！
    // Level : 在整棵大树中，node在第几层
    // h : 在整棵大树中，一共有几层
    // 返回 : 以node为头的完全二叉树有几个节点
    // 时间复杂度O((logN)的平方) ，远好于，都遍历一遍所有的节点
    private int bs(TreeNode root, int level, int height) {
        if (level == height) {
            return 1;
        }
        int rightHeight = mostLeftLevel(root.right, level + 1);
        if (rightHeight == height) {
            return (1 << (height - level)) + bs(root.right, level + 1, height);
        } else {
            return (1 << (height - level - 1)) + bs(root.left, level + 1, height);
        }
    }
    // node，此时在level层
    // 请顺着node的left指针，往下扎
    // 返回最终的深度
    public int mostLeftLevel(TreeNode head, int level) {
        while (head != null) {
            level++;
            head = head.left;
        }
        return level - 1;
    }

    //遍历树的高度
    //右树最右侧高度  右：满 不满
    //满 求出右树总数 遍历左树
    //不满
    private int process(TreeNode root, int count) {
        if (root == null) {
            return 0;
        }
        int leftCount = process(root.left, count);
        int rightCount = process(root.right, count);
        return leftCount + rightCount + 1;
    }
}
