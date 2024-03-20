package kth_largest_element_in_a_stream;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    int k;
    Queue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k)
            queue.add(val);

        else if (queue.size() < k || val > queue.peek()) {
            queue.poll();
        }
        queue.add(val);


        return queue.peek();
    }
}
