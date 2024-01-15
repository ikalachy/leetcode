package binary_search;

public class Solution {
    public int search(int[] nums, int target) {

        int start = 0, end = nums.length - 1;
        int pivot = 0 ;

        while (start <= end) {
            pivot = (end + start) / 2 ;
            if (nums[pivot] == target) {
                return pivot;
            }

            if (nums[pivot] < target) {
                start = pivot + 1;
            } else if (nums[pivot] > target) {
                end = pivot -1;

            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        result = instance.search(new int[]{-1, 0, 3, 5, 9, 12}, 13);
        System.out.println("Result: " + result);


    }
}
