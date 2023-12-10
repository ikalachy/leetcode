package generate_parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    List<String> result = new ArrayList<>();
    Stack<String> buffer = new Stack<>();

    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, n, n * 2);
        return result;
    }

    private void generateParenthesis(int opened, int closed, int total) {
        if (buffer.size() == total) {
            result.add(String.join("", buffer));
            return;
        }

        if (opened > 0) {
            buffer.push("(");
            generateParenthesis(opened - 1, closed, total);
            buffer.pop();
        }

        if (opened < closed) {
            buffer.push(")");
            generateParenthesis(opened, closed - 1, total);
            buffer.pop();
        }
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        List<String> result = instance.generateParenthesis(3);
        System.out.println("Result: " + result);

    }
}