package cn.baymax.mac03;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
//958
public class Code04_IsCBT {
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

    public boolean isCompleteTree(TreeNode root) {
        //逐层判断
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isMustLeafFlag = false;
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left == null && currentNode.right != null) {
                return false;
            }
            //// 一旦遇到不双全的节点，接下来遇到的所有节点都必须是叶！
            if (isMustLeafFlag && (currentNode.left != null || currentNode.right != null)) {
                return false;
            }
            if (currentNode.left == null || currentNode.right == null) {
                isMustLeafFlag = true;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return true;
    }
}
