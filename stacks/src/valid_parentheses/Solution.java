package valid_parentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (stack.empty() || arr[i] == '{' || arr[i] == '(' || arr[i] == '[') {
                stack.push(arr[i]);
                continue;
            }

            if (arr[i] == '}' || arr[i] == ')' || arr[i] == ']') {
                Character curr = stack.pop();
                if (arr[i] == '}' && curr != '{' || arr[i] == ')' && curr != '(' || arr[i] == ']' && curr != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        boolean result;

        result = instance.isValid("((");
        System.out.println("Result: " + result);

    }

}


