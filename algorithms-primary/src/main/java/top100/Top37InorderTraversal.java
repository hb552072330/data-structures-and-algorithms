package top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Top37InorderTraversal {
    public static List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                TreeNode cur = stack.pop();
                ans.add(cur.val);
                root = cur.right;
                continue;
            }
            stack.push(root);
            root = root.left;

        }
        return ans;
        /**
         *    1
         *     \
         *       3
         *     /
         *    2
         *
         */
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        fn(root, ans);
        return ans;
    }

    public static void fn(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        fn(root.left, ans);
        ans.add(root.val);
        fn(root.right, ans);
    }

    public static void main(String[] args) {
//        输入：root = [1,null,2,3] 输出：[1,3,2]
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        System.out.println(inorderTraversal2(t1));
    }

}
