package koko_eating_bananas;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1) {
            return (int) Math.ceil(piles[0] / (double) h);
        }

        int max = 0, min = 1;
        // 1. boundaries
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
//            min = Math.min(min, piles[i]);
        }

        // 2. search
        int tryThisBananasCount = min, result = max;
        while (min <= max) {
            tryThisBananasCount = (min + max) / 2;
            float hoursForAllPiles = 0;
            for (int i = 0; i < piles.length; i++) {
                hoursForAllPiles += (float) Math.ceil((double) piles[i] / (double) tryThisBananasCount);
            }
            System.out.printf("eat %s banana(s) and it will take %s hours%n", tryThisBananasCount, hoursForAllPiles);
            if (hoursForAllPiles > h) {
                min = tryThisBananasCount + 1;
            } else {
                if (piles.length == 1) return tryThisBananasCount;
                result = Math.min(tryThisBananasCount, result);
                max = tryThisBananasCount - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

//        result = instance.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
//        System.out.println("Result: " + result);
//
//        result = instance.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5);
//        System.out.println("Result: " + result);
//
//        result = instance.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6);
//        System.out.println("Result: " + result);

        // 14
//        result = instance.minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818);
//        System.out.println("Result: " + result);

        result = instance.minEatingSpeed(new int[]{805_306_368, 805_306_368, 805_306_368}, 1_000_000_000);
        System.out.println("Result: " + result);
    }
}
