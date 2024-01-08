package largest_rectangle_in_histogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int maxArea = -1;

        for (int i = 0; i < heights.length; i++) {
            if (!stack.isEmpty() && heights[i] < stack.peek().height) {
                Pair start = null;
                while (!stack.isEmpty() && heights[i] < stack.peek().height) {
                    start = stack.pop();
                    maxArea = Math.max(start.height() * (i - start.index()), maxArea);
                }
                stack.push(new Pair(start.index(), heights[i]));
            } else
                stack.push(new Pair(i, heights[i]));
        }

        while (!stack.isEmpty()) {
            Pair prev = stack.pop();
            maxArea = Math.max(prev.height() * (heights.length - prev.index()), maxArea);
        }

        return maxArea;
    }

    private record Pair(int index, int height) {
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

//        result = instance.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
//        System.out.println("Result: " + result); // 10

        result = instance.largestRectangleArea(new int[]{9, 0});
        System.out.println("Result: " + result); // 10


    }


}
