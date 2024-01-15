package search_a_2d_matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1, middle = 0;
        int rowIndex = -1;
        // 1. find row
        while (left <= right) {
            middle = (left + right) / 2;
            int firstEl = matrix[middle][0];
            int lastEl = matrix[middle][matrix[middle].length - 1];
            if (firstEl == target || lastEl == target) {
                return true;
            } else if (target > firstEl && target < lastEl) {
                rowIndex = middle;
                break;
            } else if (target < firstEl) {
                right = middle - 1;
            } else if (target > lastEl) {
                left = middle + 1;
            }
        }
        // 2. search column
        if (rowIndex != -1) {
            left = 0;
            right = matrix[rowIndex].length - 1;

            while (left <= right) {
                middle = (left + right) / 2;
                if (matrix[rowIndex][middle] == target) {
                    return true;
                } else if (target > matrix[rowIndex][middle]) {
                    left = middle + 1;
                } else if (target < matrix[rowIndex][middle]) {
                    right = middle - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        boolean result;

        result = instance.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 11);
        System.out.println("Result: " + result);


    }
}
