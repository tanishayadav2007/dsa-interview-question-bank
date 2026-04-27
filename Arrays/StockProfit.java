// Problem: Best Time to Buy and Sell Stock
// Company: Goldman Sachs

// Case Study:
// A trader records daily stock prices in an array.
// They want to maximize profit by choosing one day to buy
// and a later day to sell.

// Problem Statement:
// Given an array where each element represents stock price on a day,
// find the maximum profit possible from one transaction.
// If no profit is possible, return 0.

// Approach (Greedy - Single Pass):
// Track the minimum price seen so far
// At each step, calculate profit = current price - min price
// Update maximum profit accordingly

// Time Complexity: O(n)
// Space Complexity: O(1)

// Example:
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5
// Explanation:
// Buy at 1 and sell at 6 → profit = 5


public class StockProfit {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // update minimum price
            if (price < minPrice) {
                minPrice = price;
            }
            // calculate profit
            else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }
}