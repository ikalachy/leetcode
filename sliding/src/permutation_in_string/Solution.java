package permutation_in_string;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] cache1 = new int[26];
        int[] cache2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            cache1[s1.charAt(i) - 'a'] += 1;
        }


        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            cache2[s2.charAt(right) - 'a'] += 1;
            while ((right - left + 1) > s1.length()) {
                cache2[s2.charAt(left) - 'a'] -= 1;
                left += 1;
            }

            if (right - left + 1 == s1.length()) {
                if (compareCaches(cache1, cache2)) {
                    return true;
                }
            }

        }

        return false;
    }

    private boolean compareCaches(int[] cache1, int[] cache2) {
        for (int i = 0; i < cache1.length; i++) {
            if (cache1[i] != cache2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        boolean result;

        result = instance.checkInclusion("hello", "ooolleooolleh");
        System.out.println("Result: " + result);

//        result = instance.checkInclusion("ab", "baooo");
//        System.out.println("Result: " + result);


    }

}
