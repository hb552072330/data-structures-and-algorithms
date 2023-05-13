package cn.baymax.mac03;

import java.util.*;
//https://leetcode.cn/problems/binary-tree-level-order-traversal/
//102
public class Code02_LevelOrder {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans ;
        }

        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        int size = level.size();
        while (!level.isEmpty()) {
            List<Integer> curAns = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = level.poll();
                if (poll.left != null) {
                    level.add(poll.left);
                }
                if (poll.right != null) {
                    level.add(poll.right);
                }
                curAns.add(poll.val);
            }
            ans.add(curAns);
            size = level.size();
        }
        return ans;
    }

}
