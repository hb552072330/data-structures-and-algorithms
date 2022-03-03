package cn.baymax.topic;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
// 👍 1772 👎 0


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
public class Number21MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //终止条件，l1,l2链表为空
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            //将l1节点指向下一个较小的节点
            l1.next = mergeTwoLists(l1.next, l2);
            //返回当前节点
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //创建默认头节点，作为结果链表的开头
        ListNode listNode = new ListNode(0);
        //游标节点当前默认节点
        ListNode cur = listNode;
        while (l1 != null && l2 != null) {
            //如果l1的结果较小
            if (l1.val < l2.val) {
                //把l1的头部节点指向结果节点尾部
                cur.next = l1;
                //将l1指向l1的下一个节点
                l1 = l1.next;
            } else {
                //把l2的头部节点指向结果节点尾部
                cur.next = l2;
                //将l2指向l1的下一个节点
                l2 = l2.next;
            }
            //移动游标节点指向尾部
            cur = cur.next;
        }
        //合并完成后l1 或 l2有有未合并完的元素
        cur.next = l1 == null ? l2 : l1;
        //返回默认头节点的下一个元素
        return listNode.next;
    }

}
