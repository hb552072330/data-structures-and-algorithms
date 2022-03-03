package cn.baymax.topic;
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
// 进阶：
//
//
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
//
//
// 示例 3：
//
//
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
//
//
// 示例 4：
//
//
//输入：head = [1], k = 1
//输出：[1]
//
//
//
//
//
// 提示：
//
//
// 列表中节点的数量在范围 sz 内
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz
//
// Related Topics 递归 链表
// 👍 1155 👎 0


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
 * @data 2021/7/2
 */
public class Number25ReverseKGroup {

    //参数 1 -> 2 -> 3    k=2
    public ListNode reverseKGroup(ListNode head, int k) {
        //定义默认节点，用于结果的返回
        ListNode hair = new ListNode(-1);
        //将默认节点指向head节点
        hair.next = head;
        //定义头尾节点 -1 -> 1 -> 2 -> 3
        ListNode pre = hair;
        //循环节点
        while (head != null) {
            ListNode tail = pre;
            //循环获取，长度的头尾节点，
            for (int i = 0; i < k; i++) {
                //i=0 1 -> 2 -> 3  i=1 2 -> 3
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            //第一次循环后的结果  tail 2-3-null
            //临时节点 3-null
            ListNode next = tail.next;
            //翻转头尾节点
            ListNode[] nodes = reverseNode(head, tail);
            //赋值头尾节点
            head = nodes[0];
            tail = nodes[1];
            //重新连接头尾节点
            pre.next = head;
            tail.next = next;
            pre = tail;
            //将head指向节点
            head = tail.next;
        }
        return hair.next;
    }

    private ListNode[] reverseNode(ListNode head, ListNode tail) {
        //初始值1234null 34null
        //4n
        ListNode pre = tail.next;
        //1234n
        ListNode p = head;
        //首次 pre = 4n  tail  = 34n
        //二次 pre = 13n tail = 23n
        while (pre != tail) {
            //23n ；3n
            //234n ; 34n; 4n
            ListNode next = p.next;
            //p=13n ； 213n
            //14n; 214n;  314n
            p.next = pre;
            //pr=13n ； 213n
            //14n; 214n; 314n
            pre = p;
            //p=23n ； 3n
            //234n;34n; 4n
            p = next;
        }
        return new ListNode[]{tail, head};
    }


}
