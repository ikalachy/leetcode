package evaluate_reverse_polish_notation;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> ops = new Stack<>();
        for (String it : tokens) {
            if ("+".equals(it) || "-".equals(it) || "*".equals(it) || "/".equals(it)) {
                performOperation(ops, it);
            } else {
                ops.push(Integer.parseInt(it));
            }
        }

        return ops.peek();

    }

    private void performOperation(Stack<Integer> cache, String operation) {
        int a, b, result = 0;
        b = cache.pop();
        a = cache.pop();

        if ("+".equals(operation)) {
            result = a + b;
        }

        if ("-".equals(operation)) {
            result = a - b;

        }
        if ("*".equals(operation)) {
            result = a * b;

        }
        if ("/".equals(operation)) {
            result = a / b;
        }

        cache.push(result);
    }
    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        // Explanation: ((2 + 1) * 3) = 9
        result = instance.evalRPN(new String[]{"2", "1", "+", "3", "*"});
        System.out.println("Result: " + result);

        // Explanation: (4 + (13 / 5)) = 6
        result = instance.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println("Result: " + result);

    }
}