package reverse_linked_list;

import model.ListNode;

/**
 * Definition for singly-linked list.
 * public class utils.ListNode {
 * int val;
 * utils.ListNode next;
 * utils.ListNode() {}
 * utils.ListNode(int val) { this.val = val; }
 * utils.ListNode(int val, utils.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
        Solution instance = new Solution();
        ListNode result;

        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        result = instance.reverseList(head);
        System.out.println("Result: " + result);


    }
}