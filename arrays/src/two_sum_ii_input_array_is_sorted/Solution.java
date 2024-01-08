package two_sum_ii_input_array_is_sorted;

import java.util.Arrays;

public class Solution {
    // linear time
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left += 1;
            } else if (sum > target) {
                right -= 1;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return null;
    }

    // n2
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = null;

        for (int i = 0; i < numbers.length; i++) {
            int one = numbers[i];
            int j = i + 1;
            while (j < numbers.length && (numbers[j] + one) <= target) {
                int two = numbers[j];
                if ((one + two) == target)
                    return new int[]{i + 1, j + 1};
                j++;
            }
        }

        return result;
    }



    public static void main(String[] args) {
        Solution instance = new Solution();
        int[] result = instance.twoSum(new int[]{-1, 0}, -1);
        System.out.println("Result: " + Arrays.toString(result));


    }

}
