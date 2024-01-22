package model;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int count) {
        ListNode head = new ListNode();
        ListNode current = head;

        for (int i = 0; i < count; i++) {
            ListNode node = new ListNode(i + 1);
            current.next = node;
            current = current.next;
        }
        return head.next;
    }

    public static ListNode of(int[] vals) {
        ListNode head = new ListNode();
        ListNode current = head;

        for (int val : vals) {
            ListNode node = new ListNode(val);
            current.next = node;
            current = current.next;
        }
        return head.next;
    }


    @Override
    public String toString() {
        return "{ " + val + " }" + " => " + next;
    }
}

