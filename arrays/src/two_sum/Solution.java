package two_sum;

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> cache = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int element2 = target - nums[i];
            if (cache.containsKey(element2)) {
                return new int[]{cache.get(element2), i};
            }
            cache.put(nums[i], i);
        }

        throw new IllegalArgumentException("Oops,");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6))
        );
        System.out.println(
                Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9))
        );
        System.out.println(
                Arrays.toString(solution.twoSum(new int[]{2, 4, 11, 3}, 6))
        );
        System.out.println(
                Arrays.toString(solution.twoSum(new int[]{3, 3}, 6))
        );

    }
}