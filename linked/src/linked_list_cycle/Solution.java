package linked_list_cycle;

import model.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
//        System.out.println(head);
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        boolean result;

        ListNode loop = new ListNode(4);
        ListNode head = new ListNode(2, loop);
        loop.next = new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(7))));

        ListNode l1 = ListNode.of(new int[]{-1, -7, 7, -4, 19, 6, -9, -5, -2, -5});
        result = instance.hasCycle(head);
        System.out.println("Result: " + result);


    }
}
