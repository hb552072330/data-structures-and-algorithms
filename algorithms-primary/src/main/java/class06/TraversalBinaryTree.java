package class06;

/**
 * @author zhanghongbing
 * @data 2022/9/22
 */
public class TraversalBinaryTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void f(Node head) {
        if (head == null) {
            return;
        }
        f(head.left);
        f(head.right);
    }

    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }

    //      1
    //    /   \
    //   2     3
    //  / \   /  \
    // 4  5  6   7
    //先序 头 左 右  1 2 4 5 3 6 7
    //中序 左 头 右  4 2 5 1 6 3 7
    //后序 左 右 头  4 5 2 6 7 3 1
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        pre(head);
        System.out.println("--------");
        in(head);
        System.out.println("--------");
        pos(head);
    }
}
