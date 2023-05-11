package cn.baymax.mac02;

public class Code07_CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.random = node.next;
        new Code07_CopyRandomList().copyRandomList(node);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            Node node = new Node(cur.val);
            cur.next = node;
            node.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null) {
            Node copy = cur.next;
            next = cur.next.next;
            if (cur.random != null) {
                Node randmo = cur.random;
                copy.random = randmo.next;
            }
            cur = next;
        }
        cur = head;
        Node copyCur = null;
        Node ans = null;

        while (cur != null) {
            next = cur.next.next;
            if (copyCur == null) {
                ans = cur.next;
                copyCur = ans;
            } else {
                copyCur.next = cur.next;
                copyCur = copyCur.next;
            }
            cur.next = next;
            cur = next;

        }
        return ans;
    }

}
