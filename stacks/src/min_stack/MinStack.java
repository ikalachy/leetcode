package min_stack;

import java.util.*;

class MinStack {

    List<Integer> stack;
    Deque<Integer> min;

    String name;

    public MinStack(String name) {
        stack = new ArrayList<>(3 * 10_000);
        min = new ArrayDeque<>();
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void push(int val) {
        stack.add(val);

        if (min.isEmpty()) {
            min.addLast(val);
            return;
        }

        if (min.peekLast() >= val)
            min.addLast(val);
    }

    public void pop() {
        Integer removed = stack.remove(stack.size() - 1);
        if (min.peekLast() == removed) {
            min.removeLast();
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
//        Optional<Integer> min1 = stack.stream().min(Comparator.naturalOrder());
//        return min1.get();
        return min.peekLast();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack("");
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//
//        int min = minStack.getMin();
//        System.out.println(min);// return -3
//
//        minStack.pop();
//        min = minStack.top();
//        System.out.println(min);// return 0
//
//        min = minStack.getMin();
//        System.out.println(min);// return -2

        //  1 2 3 10 -1 5 6
        //             1 -1
        minStack.push(10);
        minStack.push(6);
        minStack.push(5);
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
        minStack.push(-1);

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */