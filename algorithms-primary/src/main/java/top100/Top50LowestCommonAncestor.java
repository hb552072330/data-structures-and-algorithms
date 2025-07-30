package top100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Top50LowestCommonAncestor {

    /**
     * 假设来到当前节点cur，开始时cur来到头结点位置
     * 1)如果cur没有左孩子，cur向右移动(cur =cur.rgiht)
     * a.如果cur有左孩子，找到左子树上最右的结点mostRight,挼然后cur向左移动(cur = cur.left)
     * b.如果mostRight的右指针指向cur,让其指向null，然后cur向右移动(cur = cur.right)
     * 3)cur为空时遍历停止
     *
     * @param root
     * @param p
     * @param q
     * @return
     */


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parent = new HashMap<>();
        dfs(root, parent);
        Set<Integer> set = new HashSet<>();
        while (p != null) {
            set.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null){
            if(set.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    public void dfs(TreeNode root, Map<Integer, TreeNode> parent) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left.val, root);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
        }
        dfs(root.left, parent);
        dfs(root.right, parent);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode L = lowestCommonAncestor(root.left, p, q);
        TreeNode R = lowestCommonAncestor(root.right, p, q);
        return L == null ? R : (R == null ? L : root);
    }


}
