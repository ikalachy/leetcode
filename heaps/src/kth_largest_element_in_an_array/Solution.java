package kth_largest_element_in_an_array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int num : nums) {
            if (queue.size() < k)
                queue.add(num);
            else if (num > queue.peek()) {
                queue.poll();
                queue.add(num);
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        result = instance.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println("Result: " + result);
    }
}
