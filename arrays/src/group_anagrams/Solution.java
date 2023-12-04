package group_anagrams;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> results = new ArrayList<>(strs.length);
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            boolean newAnagram = true;

            for (List<String> arr : results) {
                if (!arr.isEmpty() && isAnagram(arr.get(0), str)) {
                    arr.add(str);
                    newAnagram = false;
                    break;
                }
            }

            if (newAnagram) {
                ArrayList<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                results.add(anagrams);
            }
        }

        return results;
    }

    public static boolean isAnagram(String s, String t) {

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
//        Input: strs = ["eat","tea","tan","ate","nat","bat"]
//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        Solution solution = new Solution();
        List<List<String>> lists = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        System.out.println(lists);
    }
}