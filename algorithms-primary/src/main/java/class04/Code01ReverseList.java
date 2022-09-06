package class04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghongbing
 * @data 2022/8/31
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class Code01ReverseList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //单链表反转
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {//1 >2 >3
            next = head.next;//2
            head.next = pre;// 1 >null
            pre = head;//1>null
            head = next;
        }
        return pre;
    }

    public static ListNode reverseListByArrayList(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int size = list.size();
        for (int i = 1; i < size; i++) {
            ListNode listNode = list.get(i);
            ListNode lastListNode = list.get(i - 1);
            listNode.next = lastListNode;
        }
        return list.get(size - 1);
    }

    public static class DoubleListNode {
        int val;
        DoubleListNode next;
        DoubleListNode last;

        DoubleListNode() {
        }

        DoubleListNode(int val) {
            this.val = val;
        }

        DoubleListNode(int val, DoubleListNode next, DoubleListNode last) {
            this.val = val;
            this.next = next;
            this.last = last;
        }
    }

    public static DoubleListNode reverseDoubleList(DoubleListNode head) {
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleListNode reverseDoubleListByArrayList(DoubleListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<DoubleListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int size = list.size();
        DoubleListNode pre = list.get(0);
        for (int i = 1; i < size; i++) {
            DoubleListNode currentListNode = list.get(i);
            currentListNode.last = null;
            currentListNode.next = pre;
            pre.last = currentListNode;
            pre = currentListNode;
        }
        return list.get(size - 1);
    }

    public static ListNode generateRandomListNode(int len, int value) {
        int size = (int) (Math.random() * len);
        if (size == 0) {
            return null;
        }
        int num = (int) (Math.random() * value);
        ListNode head = new ListNode(num);
        ListNode pre = head;
        while (size != 0) {
            num = (int) (Math.random() * value);
            ListNode cur = new ListNode(num);
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    public static DoubleListNode generateRandomDoubleListNode(int len, int value) {
        int size = (int) (Math.random() * len);
        if (size == 0) {
            return null;
        }
        int num = (int) (Math.random() * value);
        DoubleListNode head = new DoubleListNode(num);
        DoubleListNode pre = head;
        while (size != 0) {
            num = (int) (Math.random() * value);
            DoubleListNode cur = new DoubleListNode(num);
            pre.next = cur;
            cur.last = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    public static List<Integer> getLinkedListOriginOrder(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.val);
            head = head.next;
        }
        return ans;
    }

    public static List<Integer> getDoubleListOriginOrder(DoubleListNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.val);
            head = head.next;
        }
        return ans;
    }

    public static boolean checkLinkedListReverse(List<Integer> origin, ListNode head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.val)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleListNode head) {
        DoubleListNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.val)) {
                return false;
            }
            end = head;
            head = head.next;
        }
        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.val)) {
                return false;
            }
            end = end.last;
        }
        return true;
    }

    public static void fun(ListNode head) {
        head = head.next;
    }

    public static void main(String[] args) {
        int len = 30;
        int maxValue = 100;
        int testTime = 100000;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            ListNode listNode = generateRandomListNode(len, maxValue);
            //System.out.println(listNode);
            //fun(listNode);
            //System.out.println(listNode);
            List<Integer> linkedListOriginOrder = getLinkedListOriginOrder(listNode);
            listNode = reverseList(listNode);
            if (!checkLinkedListReverse(linkedListOriginOrder, listNode)) {
                System.out.println("Ooops1");
            }
            ListNode listNode2 = generateRandomListNode(len, maxValue);
            List<Integer> linkedListOriginOrder2 = getLinkedListOriginOrder(listNode2);
            listNode2 = reverseListByArrayList(listNode2);
            if (!checkLinkedListReverse(linkedListOriginOrder2, listNode2)) {
                System.out.println("Ooops2");
            }
            DoubleListNode doubleListNode = generateRandomDoubleListNode(len, maxValue);
            List<Integer> doubleListOriginOrder = getDoubleListOriginOrder(doubleListNode);
            doubleListNode = reverseDoubleList(doubleListNode);
            if (!checkDoubleListReverse(doubleListOriginOrder, doubleListNode)) {
                System.out.println("Ooops3");
            }
            DoubleListNode doubleListNode2 = generateRandomDoubleListNode(len, maxValue);
            List<Integer> doubleListOriginOrder2 = getDoubleListOriginOrder(doubleListNode2);
            //System.out.println(doubleListOriginOrder2);
            doubleListNode2 = reverseDoubleListByArrayList(doubleListNode2);
            if (!checkDoubleListReverse(doubleListOriginOrder2, doubleListNode2)) {
                System.out.println("Ooops4");
            }
        }
        System.out.println("test end");

    }

}
