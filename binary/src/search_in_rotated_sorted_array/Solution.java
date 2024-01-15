package search_in_rotated_sorted_array;

public class Solution {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[left] == target) return left;
            if (nums[right] == target) return right;

            // left part
            if (nums[left] < nums[mid]) {
                if (target > nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // right part
            else {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

//        result = instance.search(new int[]{4}, 4);
//        System.out.println("Result: " + result);

//        result = instance.search(new int[]{1, 2, 3, 4, 5, 6}, 6);
//        System.out.println("Result: " + result);

        result = instance.search(new int[]{8, 1, 2, 3, 4, 5, 6, 7}, 6);
        System.out.println("Result: " + result);


    }
}
