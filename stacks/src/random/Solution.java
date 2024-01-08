package random;

import java.util.Arrays;


public class Solution {
    public static void main(String[] args) {
        Solution instance = new Solution();
        int[] result = instance.shuffle(new int[]{0, 1, 2, 3, 0, 1, 0});
        System.out.println("Result: " + Arrays.toString(result));


    }


    private int[] shuffle(int[] array) {
        int p1 = 0, p2 = array.length - 1;
        while (p1 < p2) {
            if (array[p2] == 0) {
                p2 -= 1;
                continue;
            }

            if (array[p1] == 0) {
                swap(array, p1, p2);
            }
            p1 += 1;

        }

        return array;
    }

    private void swap(int[] array, int p1, int p2) {
        int tmp = array[p1];
        array[p1] = array[p2];
        array[p2] = tmp;
    }
}
