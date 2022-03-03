package cn.baymax.topic;

import cn.baymax.common.ListNode;

import java.util.Stack;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
// Related Topics 递归 链表 👍 1233 👎 0

/**
 * @author zhanghongbing
 * @data 2021/7/1
 */
public class Number24SwapPairs {

    public ListNode swapPairs(ListNode head) {
        //递归终止条件，head为空或者下一节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //ps: 1>2>3>4
        //获取下一节点 ps:获取得到2
        ListNode next = head.next;
        //head的下一节点指向交换后的结果 ps:1指向->下次递归的结果
        head.next = swapPairs(next.next);
        //ps:2指向1
        next.next = head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        //添加空头
        ListNode dummyHead = new ListNode(0);
        //空头指向head
        dummyHead.next = head;
        ListNode temp = dummyHead;
        //如果下一节点不为空且子节点不为空 ps:队列元素 1>2>3>4
        while (temp.next != null && temp.next.next != null) {
            //获取当前节点下一个节点 ps:第一次循环是1
            ListNode next1 = temp.next;
            //获取当前节点的下下个节点 ps:第一次循环是2
            ListNode next2 = temp.next.next;
            //将当前节点指向下下个节点 ps:第一次循环将空节点指向2
            temp.next = next2;
            //第一循环将1指向3
            next1.next = next2.next;
            //第一次循环将2指向1
            next2.next = next1;
            //将1返回
            temp = next1;
        }
        return dummyHead.next;
    }

    public ListNode swapPairs3(ListNode head) {
        ListNode listNode = new ListNode(0);
        ListNode cur = head;
        head = listNode;
        //栈每次存储两个节点，先进后出
        Stack<ListNode> stack = new Stack<>();
        while (cur != null && cur.next != null) {
            //将两个元素压栈
            stack.push(cur);
            stack.push(cur.next);
            //将当前节点往前走两步
            cur = cur.next.next;
            //将两个节点弹栈，然后用listNode重新指向新的节点
            listNode.next = stack.pop();
            listNode = listNode.next;
            listNode.next = stack.pop();
            listNode = listNode.next;
        }
        //边界问题，链表为基数的时候，cur不为空
        if (cur == null) {
            listNode.next = null;
        } else {
            listNode.next = cur;
        }
        return head.next;
    }

}

