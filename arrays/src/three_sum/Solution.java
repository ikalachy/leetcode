package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right -= 1;
                } else if (sum < 0) {
                    left += 1;
                } else {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left += 1;
                    while (nums[left] == nums[left - 1] && left < right)
                        left = left + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        List<List<Integer>> result;
        //                                  = 4,-1,-1, 0,  1,  2
        result = instance.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("Result: " + result);

        result = instance.threeSum(new int[]{0, 1, 1});
        System.out.println("Result: " + result);

        result = instance.threeSum(new int[]{0, 0, 0, 0});
        System.out.println("Result: " + result);


    }
}
