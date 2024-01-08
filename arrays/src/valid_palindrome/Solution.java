package valid_palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        String letters = removeNonAlphanumericCharacters(s).toLowerCase();
        StringBuilder reversed = new StringBuilder(letters).reverse();

        return letters.contentEquals(reversed);
    }

    private String removeNonAlphanumericCharacters(String s) {
        StringBuilder buffer = new StringBuilder(s.length());
        for (char letter : s.toCharArray()) {
            if (Character.isLetter(letter) || Character.isDigit(letter)) {
                buffer.append(letter);
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        boolean result = instance.isPalindrome("0P");
//        boolean result = instance.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("Result: " + result);

    }
}
