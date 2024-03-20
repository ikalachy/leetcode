package task_scheduler;

import java.util.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        //1. count tasks
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A'] += 1;
        }

        Queue<Integer> allTasksQueue = new PriorityQueue<>(Comparator.reverseOrder());
        //2. prioritize tasks
        for (int taskCount : taskCounts) {
            if (taskCount > 0)
                allTasksQueue.offer(taskCount);
        }

        Queue<Task> delayQueue = new LinkedList<>();
        int currentCycle = 0;

        while (!allTasksQueue.isEmpty() || !delayQueue.isEmpty()) {
            currentCycle += 1;
            if (!allTasksQueue.isEmpty()) {
                Integer numberOfTasks = allTasksQueue.poll();
                numberOfTasks -= 1;
                if (numberOfTasks > 0) {
                    // delay it till n cycles
                    Task delayedTask = new Task(numberOfTasks, currentCycle + n);
                    delayQueue.offer(delayedTask);
                }
            }
            if (!delayQueue.isEmpty() && delayQueue.peek().availableOnCycle == currentCycle) {
                Task delayedTask = delayQueue.poll();
                allTasksQueue.offer(delayedTask.numberOfTasks);
            }
        }

        return currentCycle;

    }

    record Task(int numberOfTasks, int availableOnCycle) {
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        result = instance.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        System.out.println("Result: " + result);


    }
}
