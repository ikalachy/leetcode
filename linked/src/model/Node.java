package model;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node of(int i) {
        Node dummy = new Node(0);
        Node current = dummy;
        for (int j = 0; j < i; j++) {
            current.next = new Node(j + 1);
            current = current.next;
        }
        return dummy.next;
    }

    public String toString() {
        return "{ " + val + "(random: " + random + ") }" + " => " + next;
    }
}