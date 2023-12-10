package daily_temperatures;

import java.util.Arrays;
import java.util.Stack;

class Solution {

    private static class Day {
        int index;
        int val;

        public Day(int index, int val) {
            this.index = index;
            this.val = val;
        }

        static Day of(int index, int val) {
            return new Day(index, val);
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Day> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > stack.peek().val) {
                Day day = stack.pop();
                result[day.index] = i - day.index;
            }

            if (stack.isEmpty() || temperatures[i] <= stack.peek().val) {
                stack.push(Day.of(i, temperatures[i]));
            }
//            result[i] = backtrackTemperature(temperatures, i + 1, i);
        }

        return result;
    }

    private int backtrackTemperature(int[] temperatures, int currIndex, int coldDayIndex) {

        if (currIndex >= temperatures.length) return 0;
        if (temperatures[currIndex] > temperatures[coldDayIndex]) {
            return currIndex - coldDayIndex;
        }

        return backtrackTemperature(temperatures, currIndex + 1, coldDayIndex);
    }


    public static void main(String[] args) {
        Solution instance = new Solution();
        int[] result;

        result = instance.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        // Output: [1,1,4,2,1,1,0,0]
        System.out.println("Result: " + Arrays.toString(result));

        result = instance.dailyTemperatures(new int[]{30, 40, 50, 60});
        // Output: [1,1,1,0]
        System.out.println("Result: " + Arrays.toString(result));

        result = instance.dailyTemperatures(new int[]{30, 60, 90});
        // Output: [1,1,0]
        System.out.println("Result: " + Arrays.toString(result));


    }
}