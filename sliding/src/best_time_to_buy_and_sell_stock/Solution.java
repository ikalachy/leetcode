package best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int buyAt = 0, sellAt = 1;
        int result = 0;

        while (sellAt < prices.length) {
            if (prices[sellAt] > prices[buyAt]) {
                int profit = prices[sellAt] - prices[buyAt];
                result = Math.max(profit, result);
            } else {
                buyAt = sellAt;
            }
            sellAt += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        int result;

        result = instance.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("Result: " + result);

        result = instance.maxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println("Result: " + result);

        result = instance.maxProfit(new int[]{2, 1, 4});
        System.out.println("Result: " + result);


    }
}
