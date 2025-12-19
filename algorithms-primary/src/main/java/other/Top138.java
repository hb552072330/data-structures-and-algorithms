package other;

import jdk.nashorn.internal.ir.WhileNode;

/**
 * @Author zhanghongbing
 * @Date 2025-11-23 20:44
 **/
public class Top138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        //中间插入复制的节点
        while (curr != null) {
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }
        //复制随机节点
        curr = head;
        while (curr != null) {
            Node next = curr.next.next;
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = next;
        }

        //还原head，并返回
        Node dummary = new Node(0);
        Node pre = dummary;
        curr = head;
        //中间插入复制的节点
        while (curr != null) {
            Node next = curr.next.next;
            Node copy = curr.next;

            pre.next = copy;
            pre = copy;
            curr.next = next;
            curr = next;
        }
        return dummary.next;
    }
}
