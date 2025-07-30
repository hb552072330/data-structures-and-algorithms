package top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Top46RightSideView {
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode node, int depth, List<Integer> ans) {
        if (node == null) {
            return;
        }
        if (depth == ans.size()) {
            ans.add(node.val);
        }
        dfs(node.right, depth + 1, ans);
        dfs(node.left, depth + 1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            boolean isR = true;
            while (size > 0) {
                TreeNode node = q.poll();
                if (isR) {
                    ans.add(node.val);
                    isR = false;
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                size--;
            }
        }
        return ans;
    }
}
