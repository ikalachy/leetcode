package kth_largest_element_in_a_stream;

public class Solution {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        add(kthLargest, 3);   // return 4 = 2 3 4 5 8
        add(kthLargest, 5);   // return 5 = 2 4 5 5 8
        add(kthLargest, 10);  // return 5 = 2 4 5 5 8 10
        add(kthLargest, 9);   // return 8 = 2 4 5 5 8 9 10
        add(kthLargest, 4);   // return 8 = 2 4 4 5 5 8 9 10
    }

    public static void add(KthLargest kthLargest, int val) {
        int res = kthLargest.add(val);
        System.out.println(res);
    }


}
