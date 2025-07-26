package top100;

public class Top28MergeTwoLists {

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        ListNode ans = new ListNode();
        ListNode curr = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }
        return ans.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode ans = null;

        if (list1.val < list2.val) {
            ans = list1;
            list1 = list1.next;
        } else {
            ans = list2;
            list2 = list2.next;
        }
        ListNode curr = ans;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    curr.next = list1;
                    list1 = list1.next;
                } else {
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            } else if (list1 == null) {
                curr.next = list2;
                break;
            } else {
                curr.next = list1;
                break;
            }
        }
        return ans;
    }
}
