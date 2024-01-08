package remove_digit_from_number_to_maximize_result;

import java.util.*;

public class Solution {

    public String removeDigit(String number, char digit) {
        Queue<String> nums = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String s = number.substring(0, i) + number.substring(i + 1, number.length());
                nums.add(s);
            }
        }

        assert nums.peek() != null;
        return nums.peek();
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        String result = instance.removeDigit("2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471", '3');
        System.out.println("Result: " + result);

         result = instance.removeDigit("1231", '1');
        System.out.println("Result: " + result);

    }
}
