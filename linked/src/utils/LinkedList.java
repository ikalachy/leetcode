package utils;

import model.ListNode;

public class LinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode tmp = null;
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }

        return prev;
    }
}
