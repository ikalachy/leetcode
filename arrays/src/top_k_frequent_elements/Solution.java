package top_k_frequent_elements;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> result = new HashMap<>(nums.length);
        PriorityQueue<Integer> buffer = new PriorityQueue<>(k, (a, b) -> result.get(b) - result.get(a));

        for (int i = 0; i < nums.length; i++) {
            result.compute(nums[i], (key, v) -> result.getOrDefault(key, 0) + 1);
        }

        buffer.addAll(result.keySet());

        int[] topKFrequent = new int[k];
        for (int i = 0; i < k; i++) {
            topKFrequent[i] = Objects.requireNonNull(buffer.poll());
        }

        return topKFrequent;
    }

    static public class KV implements Comparable<KV> {
        int key;
        int value;

        public KV(int k, int v) {
            key = k;
            value = v;
        }

        @Override
        public int compareTo(KV o) {
            return value - o.value;

        }
    }

    public static void main(String[] args) {
//        Input: nums = [1,1,1,2,2,3], k = 2
//        Output: [1,2]

        Solution solution = new Solution();
        int[] ints = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ints));

    }
}

