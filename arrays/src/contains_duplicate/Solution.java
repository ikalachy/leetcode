package contains_duplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integers = new HashSet<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (!integers.add(nums[i]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        Input: nums = [1,2,3,1]
//        Output: true
//        Example 2:
        int[] ints1 = {1, 2, 3, 1};
        System.out.println(String.valueOf(solution.containsDuplicate(ints1)));

//        Input: nums = [1,2,3,4]
//        Output: false
//        Example 3:
        int[] ints2 = {1, 2, 3, 4};
        System.out.println(String.valueOf(solution.containsDuplicate(ints2)));

//        Input: nums = [1,1,1,3,3,4,3,2,4,2]
//        Output: true
        int[] ints3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(String.valueOf(solution.containsDuplicate(ints3)));
    }
}