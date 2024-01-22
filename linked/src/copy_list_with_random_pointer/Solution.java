package copy_list_with_random_pointer;

import model.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {

        Map<Node, Node> old2new = new HashMap<>();

        Node current = head;
        //  clone
        while (current != null) {
            Node cloned = new Node(current.val);
            old2new.put(current, cloned);
            current = current.next;
        }

        current = head;
        // remap next and random
        while (current != null) {
            Node newOne = old2new.get(current);
            newOne.random = old2new.get(current.random);
            newOne.next = old2new.get(current.next);

            current = current.next;

        }

        return old2new.get(head);
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        Node result;

        result = instance.copyRandomList(Node.of(5));
        System.out.println("Result: " + result);


    }
}
