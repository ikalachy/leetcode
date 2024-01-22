package add_two_numbers;

import model.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        System.out.println(l1);
        System.out.println(l2);

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode l3 = new ListNode(0);
        ListNode result = l3;

        int leftover = 0;

        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val;
            if (leftover > 0) {
                sum += leftover;
                leftover -= 1;
            }
            if (sum >= 10) {
                leftover += 1;
                sum = sum % 10;
            }

            l3.next = new ListNode(sum);
            l3 = l3.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int val = curr1.val;
            if (leftover > 0) {
                val += leftover;
                leftover -= 1;
            }
            if (val >= 10) {
                leftover += 1;
                val = val % 10;
            }
            l3.next = new ListNode(val);
            l3 = l3.next;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            int val = curr2.val;
            if (leftover > 0) {
                val += leftover;
                leftover -= 1;
            }
            if (val >= 10) {
                leftover += 1;
                val = val % 10;
            }
            l3.next = new ListNode(val);
            l3 = l3.next;
            curr2 = curr2.next;
        }

        if (leftover > 0)
            l3.next = new ListNode(leftover);

        return result.next;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        ListNode result;

        ListNode l2 = ListNode.of(5);

        //[2,4,9]
        //l2 =
        //[5,6,4,9]
        result = instance.addTwoNumbers(
                new ListNode(2,
                        new ListNode(4,
                                new ListNode(9))),
                new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9)))));
        System.out.println("Result: " + result);


//        l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//        result = instance.addTwoNumbers(
//                new ListNode(9,
//                        new ListNode(9,
//                                new ListNode(9,
//                                        new ListNode(9,
//                                                new ListNode(9,
//                                                        new ListNode(9,
//                                                                new ListNode(9))))))),
//                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
//        System.out.println("Result: " + result);

//        result = instance.addTwoNumbers(LinkedList.of(7), LinkedList.reverseList(l2));
//        System.out.println("Result: " + result);

    }
}
