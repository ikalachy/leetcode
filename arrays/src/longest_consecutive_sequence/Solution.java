package longest_consecutive_sequence;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        PriorityQueue<Integer> seq = new PriorityQueue<>(nums.length, Comparator.naturalOrder());

        for (int i = 0; i < nums.length; i++) {
            seq.offer(nums[i]);
        }

        int prev = seq.poll();
        int longest = 1;
        int result = 0;
        while (!seq.isEmpty()) {
            Integer curr = seq.poll();
            if (curr == prev + 1) {
                longest += 1;
            } else if (curr != prev) {
                result = Math.max(longest, result);
                longest = 1;
            }
            prev = curr;
        }
        return Math.max(longest, result);
    }

    public static void main(String[] args) {
//        Input: nums = [100,4,200,1,3,2]
//        Output: 4

        int seq = 0;

        Solution solution = new Solution();
        seq = solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(seq);

        seq = solution.longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6});
        System.out.println(seq);

        seq = solution.longestConsecutive(new int[]{1, 2, 0, 1});
        System.out.println(seq);

    }
}