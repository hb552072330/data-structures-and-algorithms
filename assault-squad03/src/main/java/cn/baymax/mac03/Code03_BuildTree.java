package cn.baymax.mac03;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//105
public class Code03_BuildTree {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }
        return recursionBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndexMap);
    }

    //输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    //输出: [3,9,20,null,null,15,7]
    //先序遍历：头->左->右
    //a->b->d->e->h->i->c->f->g
    //对于当前头结点来说，都是先左数，再右树
    //中序遍历：左->头->右
    //d->b->h->e->i->a->f->c->g
    //d->b->h->e->i     inL = 0   inR = 4 left      int inL = 5   inR = 9 right
    //a->b->d->e->h->i  preL = 1 preR = 5 left      preL = 6   preR = 9 right
    private TreeNode process(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, Map<Integer, Integer> valueIndexMap) {
        if (preL > preR) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[preL]);
        Integer headIndex = valueIndexMap.get(preorder[preL]);
        int leftSize = headIndex - inL;
        int rightSize = inR - headIndex;
        if (leftSize > 0) {
            head.left = process(preorder, preL + 1, preL + leftSize, inorder, inL, inL + leftSize - 1, valueIndexMap);
            //head.left = process(pre, pl + 1, pl + leftSize, in, il, il + leftSize - 1, valueIndexMap);
        }
        if (rightSize > 0) {
            head.right = process(preorder, preL + headIndex - inL + 1, preR, inorder, headIndex + 1, inR, valueIndexMap);
            //head.right = process(pre, pr - rightSize + 1, pr, in, ir - rightSize + 1, ir, valueIndexMap);
        }
        return head;
    }

    private TreeNode recursionBuildTree(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, Map<Integer, Integer> valueIndexMap) {
        if (preL > preR) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[preL]);
        Integer headIndex = valueIndexMap.get(preorder[preL]);
        //范围  头节点所在位置   左数大小是   headIndex- inL = leftSize  右树的大小 inR - headIndex = rightSize
        //左树先序开始  当前先序preL + 1  结束位置 preL + leftSize   中序开始 inL 结束为止 inL + leftSize -1 =  headIndex- inL + inL -1 = headIndex - 1
        head.left = recursionBuildTree(preorder, preL + 1, preL + headIndex - inL, inorder, inL, headIndex - 1, valueIndexMap);
        //右树中序开始  当前preR- rightSize + 1 = preL + leftSize + 1  结束位置 preR  中序开始  headIndex + 1 = inR -rightSize + 1 = inR - inR + headIndex + 1  结束为 inR
        head.right = recursionBuildTree(preorder, preL + headIndex - inL + 1, preR, inorder, headIndex + 1, inR, valueIndexMap);
        return head;
    }


}
