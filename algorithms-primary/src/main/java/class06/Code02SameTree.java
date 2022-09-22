package class06;

/**
 * @author zhanghongbing
 * @data 2022/9/8
 * 100
 * https://leetcode.cn/problems/same-tree
 */

/**
 * 树
 * 先序 头左右
 * 中序 左头右
 * 后续 左右头
 */
public class Code02SameTree {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null ^ q == null){
            return false;
        }
        if(p == null && q == null){
            return true;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
