package class06;

/**
 * @author zhanghongbing
 * @data 2022/9/20
 * 105
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class Code05ConstructBinaryTreeFromPreorderAndInorderTraversal {
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

    public TreeNode buildTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = L2;
        while (in[find] != pre[L1]) {
            find++;
        }
        head.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1);
        head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2);
        return head;
    }
    //第一次 l1=0 r1=4; l2=0 r2=4
    //find=l2  最终find=1
    //L第二次 l=0+1 r1=1-0+0; l2=0 r2=1-1;; R l1=0+1-0+1 r1=4 l2=1+1 r2=4
    //L第二次 l=0+1 r1=1-0+0; l2=0 r2=1-1;; R l1=2 r1=4 l2=2 r2=4
    //L第三次 l1 > r1=null  ;; L l1=2+1 r1=2+3-2  l2=2 r2=3-1;; R l1=l1+find-r1+1=4 r1=4  l2=find+1=4 r2=4
    //输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
}
