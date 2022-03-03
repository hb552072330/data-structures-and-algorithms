package cn.baymax.common;


/**
 * @author zhanghongbing
 * @data 2022/3/3
 */
public class ListNodeUtil {
    public static ListNode generateListnode(int amout) {
        ListNode listNode = null;
        ListNode currentNode = null;
        for (int i = 1; i <= amout; i++) {
            ListNode newNode = new ListNode(i);
            if (listNode == null) {
                currentNode = newNode;
            } else {
                currentNode.next = newNode;
                currentNode = newNode;
            }
            if (listNode == null) {
                listNode = currentNode;
            }
        }
        return listNode;
    }
    public static void loopNode(ListNode listNode) {
        System.out.println("---");
        ListNode next = listNode.next;
        System.out.println(listNode.val);
        while (next != null) {
            System.out.println(next.val);
            next = next.next;
        }
    }
}
