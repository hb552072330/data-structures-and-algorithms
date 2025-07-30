package top100;

import java.util.HashMap;
import java.util.Map;

public class Top48BuildTree {
    public  TreeNode buildTree(int[] preorder, int[] inorder) {
        // 1 2 4
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndex.put(inorder[i], i);
        }
        return build2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndex);
    }

    public TreeNode build2(int[] pre, int preL, int preR, int[] in, int inL, int inR, Map<Integer, Integer> valueIndex) {

        if (preL > preR) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preL]);
        if (preL == preR) {
            return node;
        }
//        for (; in[find] != pre[preL]; find++) ;
        Integer find = valueIndex.get(pre[preL]);
        node.left = build2(pre, preL + 1, preL + find - inL, in, inL, find - 1, valueIndex);
        node.right = build2(pre, preL + find - inL + 1, preR, in, find + 1, inR, valueIndex);
        return node;
    }

    public static TreeNode build(int[] pre, int preL, int preR, int[] in, int inL, int inR) {

        if (preL > preR) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preL]);
        if (preL == preR) {
            return node;
        }
        System.out.println(pre[preL]);
        int find = inL;
        for (; in[find] != pre[preL]; find++) ;
        node.left = build(pre, preL + 1, preL + find - inL, in, inL, find - 1);
        node.right = build(pre, preL + find - inL + 1, preR, in, find + 1, inR);
        return node;
    }

    public static void main(String[] args) {
//        buildTree(new int[]{3, 9, 20, 15, 7},
//                new int[]{9, 3, 15, 20, 7});
    }

}
