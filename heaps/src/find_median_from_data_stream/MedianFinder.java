package find_median_from_data_stream;

import java.util.*;

public class MedianFinder {

    Queue<Integer> smaller;
    Queue<Integer> larger;

    public MedianFinder() {
        smaller = new PriorityQueue<>(Comparator.reverseOrder());
        larger = new PriorityQueue<>();
    }

    public void addNum(int num) {
        smaller.offer(num);

        while (Math.abs(smaller.size() - larger.size()) > 1 ||
                !smaller.isEmpty() && !larger.isEmpty() && smaller.peek() > larger.peek()) {
            if (smaller.size() - larger.size() > 1) {
                larger.offer(smaller.poll());
            } else if (larger.size() - smaller.size() > 1) {
                smaller.offer(larger.poll());
            } else if (smaller.peek() > larger.peek()) {
                larger.offer(smaller.poll());
            }
        }

    }

    public double findMedian() {
        double result;

        if (smaller.size() == larger.size()) {
            result = (smaller.peek() + larger.peek()) / 2.0;
        } else if (smaller.size() > larger.size()) {
            result = smaller.peek();
        } else {
            result = larger.peek();
        }

        return result;
    }
}
