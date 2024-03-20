package find_median_from_data_stream;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(-1);
        obj.addNum(-2);
        obj.addNum(-3);
        obj.addNum(-4);
        obj.addNum(-5);
        obj.addNum(-6);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
//        System.out.println(Arrays.toString(obj.elements.toArray()));


    }
}
