package longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {

        int result = 0, left = 0;
        Set<Character> cache = HashSet.newHashSet(s.length());

        for (int right = 0; right < s.length(); right++) {
            while (cache.contains(s.charAt(right))) {
                cache.remove(s.charAt(left));
                left += 1;
            }
            cache.add(s.charAt(right));
            result = Math.max(result, right - left + 1);

        }

        return result;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        result = instance.lengthOfLongestSubstring("dvdf");
        System.out.println("Result: " + result);

        result = instance.lengthOfLongestSubstring("jbpnbwwd");
        System.out.println("Result: " + result);
//
        result = instance.lengthOfLongestSubstring("abcabcbb");
        System.out.println("Result: " + result);
//
        result = instance.lengthOfLongestSubstring("pwwkew");
        System.out.println("Result: " + result);

        result = instance.lengthOfLongestSubstring("au");
        System.out.println("Result: " + result);


    }
}
