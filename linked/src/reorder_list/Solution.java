package reorder_list;

import model.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
        System.out.println(head);

        ListNode fast = head.next;
        ListNode slow = head;

        // 1. find middle of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = head;
        ListNode left = slow.next;
        slow.next = null;
        System.out.println("left: " + left);

        // 2. reverse second list
        ListNode tmp;
        ListNode prev = null;

        while (left != null) {
            tmp = left.next;
            left.next = prev;
            prev = left;
            left = tmp;
        }

        System.out.println("reversed: " + prev);
        // 3. merge right part and left

        left = head;
        right = prev;

        while (right != null) {
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;
            left.next = right;
            right.next = leftNext;

            left = leftNext;
            right = rightNext;
        }

    }

    public static void main(String[] args) {
        Solution instance = new Solution();

        ListNode head = ListNode.of(5);

        instance.reorderList(head);
        System.out.println("Result: " + head);

    }
}
