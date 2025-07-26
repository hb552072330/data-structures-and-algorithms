package top100;

import java.util.HashMap;
import java.util.Map;

public class Top33CopyRandomList {
    public static Node copyRandomList2(Node head) {

        //构建 node1 -> node2 中间的node1'
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            Node next = curr.next;
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }
        //其次串联random
        curr = head;
        while (curr != null && curr.next != null) {
            Node random = curr.random;
            if (random != null) {
                curr.next.random = random.next;
            }
            curr = curr.next.next;
        }
        //最后剥离拷贝节点
        Node dummy = new Node(0);
        curr = head;
        Node currNew = dummy;
//        Node currOld = head;
        while (curr != null && curr.next != null) {

            currNew.next = curr.next;
            currNew = currNew.next;
            Node nextt = curr.next.next;
            curr.next = nextt;
            curr = nextt;
        }
        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        Node dummy = new Node(0);
        curr = head;
        Node copy = dummy;
        while (curr != null) {
            copy.next = map.get(curr);
            copy.next.random = map.get(curr.random);
            curr = curr.next;
            copy = copy.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        node.next = node2;
        node.random = node2;
        node2.random = node2;
        Node node1 = copyRandomList2(node);
        System.out.println(node1);
    }
}
