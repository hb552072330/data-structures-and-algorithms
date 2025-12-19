package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-06 16:44
 **/
public class Code {

    public static void main(String[] args) {
        ListNode<Integer> node = createNode(3);
        System.out.println(node);

    }

    public static ListNode<Integer> createNode(int n) {
        if (n == 0) return null;
        ListNode<Integer> root = new ListNode<Integer>();
        if (n == 1) {
            return root;
        }
        root.leftChild = createNode(n-1);
        root.rightChild = createNode(n-1);
        return root;
    }


    public static class ListNode<T> {
        //

        public ListNode() {
            parent = this;
        }

        ListNode<T> parent;
        ListNode<T> leftChild;
        ListNode<T> rightChild;
        T t;

        public ListNode<T> getParent() {
            return parent;
        }

        public void setParent(ListNode<T> parent) {
            this.parent = parent;
        }

        public ListNode<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(ListNode<T> leftChild) {
            this.leftChild = leftChild;
        }

        public ListNode<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(ListNode<T> rightChild) {
            this.rightChild = rightChild;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }


}
