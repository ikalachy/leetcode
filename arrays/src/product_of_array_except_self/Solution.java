package product_of_array_except_self;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {

        int product = 1;
        int zeroCase = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                product *= nums[i];
            else
                zeroCase += 1;
        }

        int[] result = new int[nums.length];
        if (zeroCase > 1) return result;

        for (int i = 0; i < nums.length; i++) {
            if (zeroCase > 0 && nums[i] == 0) {
                result[i] = product;
            }
            if (zeroCase == 0 && nums[i] != 0) {
                result[i] = product / nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        Input: nums = [1,2,3,4] {1, 1, 0, 2, 4, 0 ]
//        Output: [24,12,8,6]
        Solution solution = new Solution();
        int[] ints = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));

//        Input: nums = [-1,1,0,-3,3]
//        Output: [0,0,9,0,0]
        ints = solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        System.out.println(Arrays.toString(ints));
    }
}
