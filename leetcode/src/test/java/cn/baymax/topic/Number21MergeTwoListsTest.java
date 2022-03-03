package cn.baymax.topic;

import cn.baymax.common.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhanghongbing
 * @data 2021/7/2
 */
public class Number21MergeTwoListsTest {

    @Test
    public void mergeTwoLists() {
        ListNode listNode = generateListnode(5);
        ListNode listNode2 = generateListnode(4);
        loopNode(listNode);
        loopNode(listNode2);
        Number21MergeTwoLists number21MergeTwoLists = new Number21MergeTwoLists();
        ListNode listNode1 = number21MergeTwoLists.mergeTwoLists(listNode, listNode2);
        loopNode(listNode1);
    }

    private ListNode generateListnode(int amout) {
        ListNode listNode = null;
        ListNode currentNode = null;
        for (int i = 1; i < amout; i++) {
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

    private void loopNode(ListNode listNode) {
        System.out.println("---");
        ListNode next = listNode.next;
        System.out.println(listNode.val);
        while (next != null) {
            System.out.println(next.val);
            next = next.next;
        }
    }
}