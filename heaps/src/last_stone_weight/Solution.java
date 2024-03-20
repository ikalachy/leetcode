package last_stone_weight;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int lastStoneWeight(int[] stones) {

        if (stones.length == 1) return stones[0];
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }

        while (!queue.isEmpty() && queue.size() > 1) {
            int stone1 = queue.poll();
            int stone2 = queue.poll();

            if (stone1 != stone2) {
                queue.add(Math.abs(stone2 - stone1));
            }
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        result = instance.lastStoneWeight(new int[]{2, 7});
        System.out.println("Result: " + result);


    }
}
