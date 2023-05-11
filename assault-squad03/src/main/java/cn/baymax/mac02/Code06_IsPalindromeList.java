package cn.baymax.mac02;

import java.util.Stack;

//https://leetcode.cn/problems/palindrome-linked-list/
//234
public class Code06_IsPalindromeList {
     static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (stack.pop().equals(cur.val)) {
                cur = cur.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        new Code06_IsPalindromeList().isPalindrome3(head);
    }

    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //快慢指针获取重点
        ListNode mid = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null) {
            mid = mid.next;
            quick = quick.next.next;
        }

        //获取中间节点的next节点
        ListNode rightLast = mid.next;
        ListNode next = rightLast.next;
        rightLast.next = null;
        ListNode cur = next;
        while (cur != null) {
            next = cur.next;
            cur.next = rightLast;
            rightLast = cur;
            cur = next;
        }

        cur = rightLast;
        next = head;
        boolean flag = true;
        while (cur != null) {
            if (next.val != cur.val) {
                flag = false;
                break;
            }
            cur = cur.next;
            next = next.next;
        }
        cur = rightLast;
        rightLast = null;
        while (cur != null) {
            next = cur.next;
            cur.next = rightLast;
            rightLast = cur;
            cur = next;
        }
        mid.next= rightLast;
        return flag;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //栈结构能解决
        //翻转前半段链表
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        //奇数
        boolean flag = (1 & count) == 1;
        int mid = count / 2;
        count = 0;

        ListNode next = null;
        cur = head;
        ListNode pre = null;
        ListNode reverse = null;
        ListNode unReverse = null;
        while (cur != null) {
            count++;
            if (count > mid) {
                //比较
                if (flag) {
                    //奇数跳跃中间节点
                    cur = cur.next;
                    flag = false;
                }
                if (pre.val != cur.val) {
                    return false;
                }
                pre = pre.next;
                cur = cur.next;
            } else {
                //翻转
                // 1->2->3
                //2
                next = cur.next;
                //1 -> null
                cur.next = pre;
                // 当前 -> 1 -> null
                pre = cur;
                //当前 -> 2
                cur = next;

                if (count == mid) {
                    unReverse = cur;
                    reverse = pre;
                }
            }
            //还原链表
            while (reverse != null) {
                next = reverse.next;
                reverse.next = unReverse;
                unReverse = reverse;
                reverse = next;
            }
        }
        return true;
    }
}
