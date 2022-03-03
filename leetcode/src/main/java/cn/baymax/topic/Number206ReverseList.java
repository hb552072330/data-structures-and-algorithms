package cn.baymax.topic;
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：[2,1]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
//
// Related Topics 递归 链表
// 👍 1819 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import cn.baymax.common.ListNode;

/**
 * @author zhanghongbing
 * @data 2021/7/1
 */
public class Number206ReverseList {

    public ListNode reverseList(ListNode head) {
        //递归终止条件，当前head为空或者下一节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //res就是最后一个节点
        ListNode res = reverseList(head.next);
        // 1 > 2 > 3 > 4 那么current就是4
        //head是3，head的下一个就是4
        //所以head.next.next 4>3
        head.next.next = head;
        //防止链表循环，将head.next设为空
        head.next = null;
        //每层递归函数都返回cur,也就是最后一个节点
        return res;
    }

    public ListNode reverseList2(ListNode head) {
        //如果链表为空直接返回
        if (head == null) {
            return head;
        }
        //获取链表的下一个节点
        ListNode node = head.next;
        //将头结点指向空
        head.next = null;
        while (node != null) {
            ListNode tempNode = node.next;
            //将当前节点的下一个节点指向头节点
            node.next = head;
            //头节点等于当前节点
            head = node;
            //当前节点指向下一个节点
            node = tempNode;
        }
        return head;
    }

    public ListNode reverseList3(ListNode head) {
        //申请节点，pre指向null, cur指向头节点
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //记录下一个节点
            ListNode temp = cur.next;
            //将当前节点指向pre
            cur.next = pre;
            //pre和cur都前进一个节点
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

