package sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        // hold indexes
        Deque<Integer> deque = new ArrayDeque<>();

        for (int right = 0; right < nums.length; right++) {

            while (!deque.isEmpty() && nums[right] > nums[deque.peekLast()])
                deque.pollLast();

            deque.addLast(right);

            while (right - left + 1 > k) {
                if (deque.peekFirst() == left)
                    deque.pollFirst();

                left += 1;
            }

            if ((right - left + 1) == k)
                result.add(nums[deque.peekFirst()]);

        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int[] result;

        result = instance.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println("Result: " + result);


    }
}
