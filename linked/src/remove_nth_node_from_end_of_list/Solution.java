package remove_nth_node_from_end_of_list;

import model.ListNode;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        System.out.println(head);

        if (head.next == null) return null;

        int distance = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        // 1. rewind to n-th element
        while (right != null) {
            if (distance >= n) {
                left = left.next;
            }
            right = right.next;
            distance += 1;
        }

        System.out.println("n-th: " + left);
        System.out.println("prev: " + dummy);
        // 2. remove
        left.next = left.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        ListNode result;

        result = instance.removeNthFromEnd(ListNode.of(2), 1);
        System.out.println("Result: " + result);

//        result = instance.removeNthFromEnd(LinkedList.of(1), 1);
//        System.out.println("Result: " + result);


    }
}
