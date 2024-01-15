package median_of_two_sorted_arrays;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int left = 0, right = 0;
        List<Integer> result = new ArrayList<>(nums1.length + nums2.length);

        while (left < nums1.length && right < nums2.length) {
            int first = nums1[left];
            int second = nums2[right];

            if (first < second) {
                left += 1;
                result.add(first);
            } else if (first > second) {
                right += 1;
                result.add(second);
            } else {
                left += 1;
                right += 1;
                result.add(second);
                result.add(first);
            }
        }

        while (left < nums1.length) {
            result.add(nums1[left]);
            left += 1;
        }
        while (right < nums2.length) {
            result.add(nums2[right]);
            right += 1;
        }
        // 1  3  4
        System.out.println(result);
        if (result.size() % 2 > 0) {
            int index = result.size() / 2;
            return (double) result.get(index);
        } else {
            int index = result.size() / 2;
            return (result.get(index) + (double) result.get(index - 1)) / 2;
        }
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        double result;

        result = instance.findMedianSortedArrays(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4}, new int[]{1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4});
        System.out.println("Result: " + result);


    }
}
