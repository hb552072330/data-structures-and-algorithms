package top100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Top47Flatten {
    public void flatten2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode pro = next;
                while (pro.right != null) {
                    pro = pro.right;
                }
                pro.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

//    1,2,4

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;

    }


    public void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            dummy.right = pop;
            dummy = pop;
            if (pop.right != null) {
                stack.push(pop.right);
                pop.right = null;
            }
            if (pop.left != null) {
                stack.push(pop.left);
                pop.left = null;
            }
        }
    }
}
