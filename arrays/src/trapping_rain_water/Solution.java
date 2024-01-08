package trapping_rain_water;

public class Solution {
    public int trap(int[] height) {

        int water = 0, left = 0, right = height.length - 1, maxleft = 0, maxright = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (maxleft - height[left] > 0) {
                    water += maxleft - height[left];
                }
                maxleft = Math.max(maxleft, height[left]);
                left += 1;
            } else {
                if (maxright - height[right] > 0) {
                    water += maxright - height[right];
                }
                maxright = Math.max(maxright, height[right]);
                right -= 1;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result = 0;

        result = instance.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println("Result: " + result);

        //            5
        //  4 * * * * 5
        //  4 * * 3 * 5
        //  4 2 * 3 2 5
        //  4 2 * 3 2 5
        result = instance.trap(new int[]{4, 2, 0, 3, 2, 5});
        System.out.println("Result: " + result);


    }
}
