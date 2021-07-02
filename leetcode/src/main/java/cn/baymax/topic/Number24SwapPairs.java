package cn.baymax.topic;

/**
 * @author zhanghongbing
 * @data 2021/7/1
 */
public class Number24SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
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
        while (temp.next != null && temp.next.next != null){
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
}

