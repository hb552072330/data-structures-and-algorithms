package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-23 19:35
 **/
public class Top21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummary = new ListNode();
        ListNode current = dummary;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                current.next = list2;
                current = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            }
        }
        while (list2 != null) {
            current.next = list2;
            current = list2;
            list2 = list2.next;
        }
        while (list1 != null) {
            current.next = list1;
            current = list1;
            list1 = list1.next;
        }
        return dummary.next;
    }

}
