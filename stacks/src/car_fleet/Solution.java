package car_fleet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Float> fleets = new Stack<Float>();
        Car[] cars = new Car[position.length];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i], (float) (target - position[i]) / speed[i]);
        }
        // 5, 2,66 , 6
        Arrays.sort(cars, Comparator.comparingInt(Car::position).reversed());
        for (int i = 0; i < cars.length; i++) {
            float timeToTarget = cars[i].time2Target();
            if (fleets.isEmpty() || timeToTarget > fleets.peek()) {
                fleets.push(timeToTarget);
            }
        }
        return fleets.size();
    }

    public record Car(int position, int speed, float time2Target) {
    }


    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

//        Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
//        Output: 3
        result = instance.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3});
        System.out.println("Result: " + result);

//        Input: target = 10, position = [3], speed = [3]
//        Output: 1
        result = instance.carFleet(10, new int[]{3}, new int[]{3});
        System.out.println("Result: " + result);

        result = instance.carFleet(10, new int[]{6, 8}, new int[]{3, 2});
        System.out.println("Result: " + result); // 2

        result = instance.carFleet(10, new int[]{0, 4, 2}, new int[]{2, 1, 3});
        // 10-0/2=5 -> 6/1=6 -> 8/3=2.3
        System.out.println("Result: " + result); // 1


    }
}
