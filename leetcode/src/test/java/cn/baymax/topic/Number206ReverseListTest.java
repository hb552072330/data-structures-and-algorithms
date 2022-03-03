package cn.baymax.topic;

import cn.baymax.common.ListNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhanghongbing
 * @data 2021/7/1
 */
public class Number206ReverseListTest {

    @Test
    public void reverseList() {
        Number206ReverseList number206ReverseList = new Number206ReverseList();
        ListNode listNode = null;
        ListNode currentNode = null;
        for (int i = 1; i < 5; i++) {
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
        loopNode(listNode);
        listNode = number206ReverseList.reverseList(listNode);
        System.out.println("reverseList");
        loopNode(listNode);
        listNode = number206ReverseList.reverseList2(listNode);
        System.out.println("reverseList2");
        loopNode(listNode);
        listNode = number206ReverseList.reverseList3(listNode);
        System.out.println("reverseList3");
        loopNode(listNode);
    }

    private void loopNode(ListNode listNode) {
        ListNode next = listNode.next;
        System.out.println(listNode.val);
        while (next != null) {
            System.out.println(next.val);
            next = next.next;
        }
    }
}