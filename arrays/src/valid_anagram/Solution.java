package valid_anagram;

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] cache = new int[26];

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int index1 = Character.codePointAt(sArr, i) - 97;
            cache[index1] += 1;

            int index2 = Character.codePointAt(tArr, i) - 97;
            cache[index2] -= 1;
        }

        for (int i = 0; i < cache.length; i++) {
            if (cache[i] != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "anagram", t = "nagaram";
//        String s = "rat", t = "car";

        boolean anagram = solution.isAnagram(s, t);
        System.out.println(anagram);


    }
}