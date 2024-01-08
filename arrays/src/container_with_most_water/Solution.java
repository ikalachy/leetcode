package container_with_most_water;

public class Solution {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] <= height[right]) {
                left += 1;
            } else if (height[left] > height[right]) {
                right -= 1;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result = instance.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println("Result: " + result);


    }
}
