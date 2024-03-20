package k_closest_points_to_origin;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    record Point(double distance, int[] point) {
    }

    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> queue = new PriorityQueue<>(Comparator.comparingDouble(Point::distance).reversed());

        //1. calc distance
        for (int[] point : points) {
            int sqrt = point[0] * point[0] + point[1] * point[1];
            Point calc = new Point(sqrt, point);
            if (queue.size() < k)
                queue.offer(calc);
            else if (sqrt < queue.peek().distance) {
                queue.poll();
                queue.offer(calc);
            }
        }

        return queue.stream()
                .map(p -> p.point)
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int[][] result;

//        result = instance.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
//        System.out.println("Result: " + Arrays.deepToString(result));

//        Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//        Output: [[3,3],[-2,4]]
        result = instance.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        System.out.println("Result: " + Arrays.deepToString(result));
    }
}
