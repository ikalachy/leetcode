package find_minimum_in_rotated_sorted_array;

public class Solution {
    public int findMin(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int left = 0, right = nums.length - 1;
        int result = nums[0];

        while (left <= right) {
            if (nums[left] < nums[right]) {
                return Math.min(nums[left], result);
            }

            int pivot = (left + right) / 2;
            result = Math.min(nums[pivot], result);

            if (nums[pivot] >= nums[left]) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;


        // expected: 1
        result = instance.findMin(new int[]{5, 1, 2, 3, 4});
        System.out.println("Result: " + result);

        result = instance.findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println("Result: " + result);

        result = instance.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println("Result: " + result);

        result = instance.findMin(new int[]{11, 13, 15, 17});
        System.out.println("Result: " + result);

        result = instance.findMin(new int[]{2, 3, 4, 5, 1});
        System.out.println("Result: " + result);


    }
}
