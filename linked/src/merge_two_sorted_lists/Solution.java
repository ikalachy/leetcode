package merge_two_sorted_lists;

import model.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode current = new ListNode();
        ListNode result = current;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                current.next = new ListNode(list1.val);
                if (list1 != null)
                    list1 = list1.next;
            } else if (list1.val > list2.val) {
                current.next = new ListNode(list2.val);
                if (list2 != null)
                    list2 = list2.next;
            } else {
                current.next = new ListNode(list1.val);
                current = current.next;
                current.next = new ListNode(list2.val);

                list1 = list1.next;
                list2 = list2.next;
            }
            current = current.next;

        }

        while (list1 != null) {
            current.next = new ListNode(list1.val);
            current = current.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            current.next = new ListNode(list2.val);
            current = current.next;
            list2 = list2.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        ListNode result;

        ListNode list1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(4, new ListNode(5))));
        ListNode list2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4)));

        result = instance.mergeTwoLists(list1, list2);
        System.out.println("Result: " + result);

    }


}
