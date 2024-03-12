package merge_intervals;

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(anInt -> anInt[0]));
        Deque<int[]> queue = new LinkedList<>();
        queue.addLast(intervals[0]);


        for (int[] interval : intervals) {
            int[][] merged = mergeIntervals(queue.pollLast(), interval);
            for (int[] inter : merged) {
                queue.addLast(inter);
            }
        }

        return queue.toArray(new int[][]{});
    }

    private int[][] mergeIntervals(int[] interval, int[] interval2) {
        int start1 = interval[0], end1 = interval[1];
        int start2 = interval2[0], end2 = interval2[1];

        if (start2 > end1)
            return new int[][]{interval, interval2};

        if (end2 <= end1)
            return new int[][]{interval};
        else
            return new int[][]{new int[]{start1, end2}};
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int[][] result;

        result = instance.merge(new int[][]{{2, 6}, {1, 3}, {8, 10}, {15, 18}});
        System.out.println("Result: " + Arrays.asList(result));


    }
}
