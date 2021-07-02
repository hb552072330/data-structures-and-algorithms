package cn.baymax.topic;

import org.junit.Test;

import java.awt.image.LookupOp;

import static org.junit.Assert.*;

/**
 * @author zhanghongbing
 * @data 2021/7/1
 */
public class Number24SwapPairsTest {

    @Test
    public void swapPairs() {
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
        Number24SwapPairs number24SwapPairs = new Number24SwapPairs();
        System.out.println("swapPairs");
        loopNode(number24SwapPairs.swapPairs(listNode));
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