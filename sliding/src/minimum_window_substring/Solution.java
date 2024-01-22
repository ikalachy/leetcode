package minimum_window_substring;


public class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length() || t.isEmpty()) return "";

        int haveMatches = 0, left = 0;
        int[] result = new int[]{-1, -1};

        int[] cacheS = new int[58];
        int[] cacheT = new int[58];

        for (char ch : t.toCharArray()) {
            cacheT[ch - 'A'] += 1;
        }

        for (int right = 0; right < s.length(); right++) {
            cacheS[s.charAt(right) - 'A'] += 1;

            if (cacheS[s.charAt(right) - 'A'] <= cacheT[s.charAt(right) - 'A']) {
                haveMatches += 1;
            }


            while (haveMatches == t.length()) {
                if (result[0] == -1 || (right - left + 1) < result[1] - result[0]) {
                    result[0] = left;
                    result[1] = Math.min(right + 1, s.length());
                }
                cacheS[s.charAt(left) - 'A'] -= 1;
                if (cacheS[s.charAt(left) - 'A'] < cacheT[s.charAt(left) - 'A']) {
                    haveMatches -= 1;
                }
                left += 1;
            }
        }

        return result[0] == -1 ? "" : s.substring(result[0], Math.min(result[1], s.length()));
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        String result;

//        result = instance.minWindow("ADOBECODEBANC", "ABC");
//        System.out.println("Result: " + result);
//
//        result = instance.minWindow("a", "b");
//        System.out.println("Result: " + result);

        result = instance.minWindow("aa", "aa");
        System.out.println("Result: " + result);


    }
}
