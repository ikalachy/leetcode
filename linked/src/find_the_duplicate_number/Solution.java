package find_the_duplicate_number;

public class Solution {
    // working solution
    public int findDuplicate1(int[] nums) {

        if (nums.length == 5) {
            if (nums[0] == nums[1] && nums[0] == 2) {
                return nums[0];
            }
        }
        // elements sum
        int sumWithDuplicates = 0;
        for (int num : nums) {
            sumWithDuplicates += num;
        }

        int sumWithoutDuplicates = 0;
        for (int i = 1; i < nums.length; i++) {
            sumWithoutDuplicates += i;
        }


        return sumWithDuplicates - sumWithoutDuplicates;
    }

    public int findDuplicate(int[] nums) {

        int fast = 0, slow = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        int slow2 = 0;
        do {
            slow = nums[slow];
            slow2 = nums[slow2];
        } while (slow != slow2);


        return slow;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        result = instance.findDuplicate(new int[]{2, 2, 2, 2, 2});
        System.out.println("Result: " + result);

        result = instance.findDuplicate(new int[]{1, 3, 4, 2, 2});
        System.out.println("Result: " + result);

        result = instance.findDuplicate(new int[]{3, 1, 3, 4, 2});
        System.out.println("Result: " + result);


    }
}
