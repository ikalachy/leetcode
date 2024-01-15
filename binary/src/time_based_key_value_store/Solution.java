package time_based_key_value_store;


public class Solution {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();

        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);

        System.out.println(timeMap.get("pp", 5));
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
        System.out.println(timeMap.get("love", 25));
    }
}
